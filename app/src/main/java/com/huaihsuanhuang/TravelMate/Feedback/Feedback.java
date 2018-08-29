package com.huaihsuanhuang.TravelMate.Feedback;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.huaihsuanhuang.TravelMate.Adapter.ChatViewHolder;
import com.huaihsuanhuang.TravelMate.R;
import com.huaihsuanhuang.TravelMate.model.MessageInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


public class Feedback extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    private FirebaseAuth mAuth;
    private FirebaseRecyclerAdapter<MessageInfo, ChatViewHolder> firebase_adapter;
    private static int SIGN_IN_REQUEST_CODE = 1;
    ConstraintLayout activity_feedback;
    FloatingActionButton feedback_snedbtn;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_IN_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                Snackbar.make(activity_feedback, "Successfully signed in! Welcome " + mAuth.getCurrentUser().getDisplayName(),
                        Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(activity_feedback, "Failed signed in. Please try again later.", Snackbar.LENGTH_SHORT).show();
                finish();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        activity_feedback = findViewById(R.id.activity_feedback);
        mAuth = FirebaseAuth.getInstance();

        final FirebaseUser user = mAuth.getCurrentUser();

        updateuserstatus(user);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Feedback");

        feedback_snedbtn = findViewById(R.id.feedback_sendbtn);
        feedback_snedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = findViewById(R.id.feedback_edit_text);
                long currentTime = System.currentTimeMillis();
                Date date = new Date(currentTime);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                HashMap<String, String> mhashmap = new HashMap<>();
                mhashmap.put("text", input.getText().toString());
                mhashmap.put("user", user.getUid());
                mhashmap.put("time", formatter.format(date));

                reference.child(formatter.format(date)).setValue(mhashmap);
                Toast.makeText(getBaseContext(), "Thank you for your kindly feedback", Toast.LENGTH_LONG).show();
                input.setText("");

            }
        });


    }


    private void updateuserstatus(FirebaseUser user) {
        if (user == null) {
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(), SIGN_IN_REQUEST_CODE);
        } else {

            Snackbar.make(activity_feedback, "Welcome " + mAuth.getCurrentUser().getDisplayName(),
                    Snackbar.LENGTH_SHORT).show();

        }
    }


}
