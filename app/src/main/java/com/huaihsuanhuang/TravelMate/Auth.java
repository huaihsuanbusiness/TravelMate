package com.huaihsuanhuang.TravelMate;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Auth extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseAuth mAuth;
    TextInputEditText login_input_account;
    TextInputEditText login_input_password;
    TextView login_status;
    Button login_button_login,login_button_createaccount,login_button_forget;
    SignInButton login_button_google;
    private static final int RC_SIGN_IN=1;
    private GoogleSignInClient mGoogleSignInClient ;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        login_input_account=findViewById(R.id.login_input_account);
        login_input_password= findViewById(R.id.login_input_password);
        login_status=findViewById(R.id.login_status);
        login_button_login=findViewById(R.id.login_button_login);
        login_button_createaccount=findViewById(R.id.login_button_createaccount);
        login_button_forget=findViewById(R.id.login_button_forget);
        login_button_google =findViewById(R.id.login_button_google);
        TextView textView = (TextView) login_button_google.getChildAt(0);
        textView.setText("Login with Google");
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        updateuserstatus(user);

        mAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = mAuth.getCurrentUser();
                updateuserstatus(user);
            }
        });

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient= GoogleSignIn.getClient(this,gso);

        login_button_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        View view =findViewById(R.id.auth_layout);
        view.getBackground().setAlpha(60);
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
       // Toast.makeText(Auth.this,"Login Successful!\n"+ " Welcome back",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("google signin failed", "Google sign in failed", e);
                // ...
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {


        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("googlesigninsuccess", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateuserstatus(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("signinfailure", "signInWithCredential:failure", task.getException());
                            Snackbar.make(getCurrentFocus(),"Google Login Failed", Snackbar.LENGTH_LONG).show();
                            updateuserstatus(null);
                        }

                        // ...
                    }
                });
    }


    public void updateuserstatus(FirebaseUser user){
      //  FirebaseUser user = mAuth.getCurrentUser();
        if(user==null){
            login_button_login.setText("LogIn");
            login_status.setText("Not logged in");
            login_button_createaccount.setVisibility(View.VISIBLE);
            login_button_forget.setVisibility(View.VISIBLE);
            login_button_google.setVisibility(View.VISIBLE);
        }
        else {

            login_button_login.setText("LogOut");
            login_status.setText(user.getDisplayName()+" you are logged in by email\n"+user.getEmail()+"\nVerified status:  "+user.isEmailVerified());
            login_button_createaccount.setVisibility(View.INVISIBLE);
            login_button_forget.setVisibility(View.INVISIBLE);
            login_button_google.setVisibility(View.INVISIBLE);
            if(!(user.isEmailVerified())){
                user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Auth.this,"Please check your mailbox",Toast.LENGTH_LONG).show();
                    }

                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Auth.this,"Failure sending the mail"+e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }


        }
    }
    public void onClick_forget(View view) {

        String string_account =login_input_account.getText().toString();
        String string_password = login_input_password.getText().toString();
        if (string_account.isEmpty()){
            Toast.makeText(this,"Please enter account",Toast.LENGTH_LONG).show();
            return;
        }
        mAuth.sendPasswordResetEmail(string_account).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                Toast.makeText(Auth.this,"Please check your mailbox",Toast.LENGTH_LONG).show();
            }}
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Auth.this,"Failure:  "+e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
    public void onClick_CreateAccountlink(View view) {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);

    }

    public void onClick_login(View view) {
        final FirebaseUser user = mAuth.getCurrentUser();
        if(user==null){
            String string_account =login_input_account.getText().toString();
            String string_password = login_input_password.getText().toString();
            if (string_account.isEmpty()){
                Toast.makeText(this,"Please enter account",Toast.LENGTH_LONG).show();
                return;
            }
            if (string_password.isEmpty()){
                Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(string_account,string_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){

                        Toast.makeText(Auth.this,"Login Successful!\n"+ " Welcome back",Toast.LENGTH_LONG).show();
                        finish();
                    }


                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Auth.this,"Login failure "+e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
            });

        }
        else {
         mAuth.signOut();
        }


    }




}
