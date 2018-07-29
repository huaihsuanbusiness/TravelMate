package com.huaihsuanhuang.TravelMate;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class CreateAccount extends AppCompatActivity {

    TextInputEditText create_input_account;
    TextInputEditText create_input_display;
    TextInputEditText create_input_password;
    TextInputEditText create_input_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        create_input_account=findViewById(R.id.create_input_account);
        create_input_display=findViewById(R.id.create_input_display);
        create_input_password=findViewById(R.id.create_input_password);
        create_input_confirm=findViewById(R.id.create_input_confirm);

        View view =findViewById(R.id.createaccount_layout);
        view.getBackground().setAlpha(60);

    }


    public void onClick_creatAccount(View view) {
        final String account = create_input_account.getText().toString();
        final String display = create_input_display.getText().toString();
        final String password =create_input_password.getText().toString();
        final String confirm = create_input_confirm.getText().toString();

        if (account.isEmpty()){
            Toast.makeText(this,"Please enter account",Toast.LENGTH_LONG).show();
            return;
        }
        if (display.isEmpty()){
            Toast.makeText(this,"Please enter display name",Toast.LENGTH_LONG).show();
            return;
        }
        if (password.isEmpty()){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }
        if (confirm.isEmpty()){
            Toast.makeText(this,"Confirm passward",Toast.LENGTH_LONG).show();
            return;
        }
        if (!(password.equals(confirm))){
            Toast.makeText(this,"Confirm password",Toast.LENGTH_LONG).show();
            return;
        }


        final FirebaseAuth myAuth = FirebaseAuth.getInstance();
        myAuth.createUserWithEmailAndPassword(account,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               if (task.isSuccessful()){
                   Toast.makeText(CreateAccount.this,"Account Created",Toast.LENGTH_LONG).show();
                   FirebaseUser user = myAuth.getCurrentUser();
                   UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                           .setDisplayName(display).build();
                   user.updateProfile(request);
                   myAuth.signOut();
                   myAuth.signInWithEmailAndPassword(account,password);

               finish();
               }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(CreateAccount.this,"Fail reason: "+e.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }
}
