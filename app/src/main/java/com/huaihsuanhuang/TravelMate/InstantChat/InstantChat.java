package com.huaihsuanhuang.TravelMate.InstantChat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.huaihsuanhuang.TravelMate.Adapter.ChatViewHolder;
import com.huaihsuanhuang.TravelMate.R;
import com.huaihsuanhuang.TravelMate.model.MessageInfo;

import java.text.SimpleDateFormat;
import java.util.Date;


public class InstantChat extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    private FirebaseAuth mAuth;
    private FirebaseRecyclerAdapter<MessageInfo, ChatViewHolder> firebase_adapter;
    private static int SIGN_IN_REQUEST_CODE = 1;
    ConstraintLayout activity_instant_chat;
    FloatingActionButton chat_snedbtn;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_IN_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                Snackbar.make(activity_instant_chat, "Successfully signed in! Welcome " + mAuth.getCurrentUser().getDisplayName(),
                        Snackbar.LENGTH_SHORT).show();
                displaymessgae();
            } else {
                Snackbar.make(activity_instant_chat, "Failed signed in. Please try again later.", Snackbar.LENGTH_SHORT).show();
                finish();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instant_chat);
        activity_instant_chat = findViewById(R.id.activity_instant_chat);
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();

        updateuserstatus(user);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("InstantChat");

        chat_snedbtn = findViewById(R.id.chat_sendbtn);
        chat_snedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = findViewById(R.id.chat_edit_text);
                FirebaseDatabase.getInstance().getReference().push().setValue(
                        new MessageInfo(input.getText().toString(), mAuth.getCurrentUser().getDisplayName()));
                input.setText("");
            }
        });

        displaymessgae();
    }

    private void displaymessgae() {
        RecyclerView recyclerView = findViewById(R.id.chat_recyclerview);
        FirebaseRecyclerOptions<MessageInfo> options =
                new FirebaseRecyclerOptions.Builder<MessageInfo>()
                        .setQuery(reference, MessageInfo.class)
                        .build();
        firebase_adapter = new FirebaseRecyclerAdapter<MessageInfo, ChatViewHolder>(options) {

            @Override
            protected void onBindViewHolder(@NonNull ChatViewHolder holder, int position, @NonNull MessageInfo model) {

                holder.chat_sticker.setText(model.getMsg_User().charAt(0));
                holder.chat_message.setText(model.getMsg_Text());
//TODO 似乎沒被叫到 沒set進去
                long currentTime = System.currentTimeMillis();
                Date date = new Date(currentTime);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                holder.chat_time.setText(formatter.format(date));
                MessageInfo setfb_MessageInfo = new MessageInfo(model.getMsg_Text(), model.getMsg_User());
//TODO current time & reference 錯誤 (沒建立並存到reference裡面)
                reference.child(formatter.format(date)).setValue(setfb_MessageInfo);
            }

            @NonNull
            @Override
            public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.chat_item, parent, false);
                return new ChatViewHolder(view);
            }

        };
        firebase_adapter.notifyDataSetChanged();
        recyclerView.setAdapter(firebase_adapter);
    }

    private void updateuserstatus(FirebaseUser user) {
        if (user == null) {
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(), SIGN_IN_REQUEST_CODE);
        } else {
            displaymessgae();
            Snackbar.make(activity_instant_chat, "Welcome " + mAuth.getCurrentUser().getDisplayName(),
                    Snackbar.LENGTH_SHORT).show();

        }
    }


}
