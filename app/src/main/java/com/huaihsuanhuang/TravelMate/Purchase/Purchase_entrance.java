package com.huaihsuanhuang.TravelMate.Purchase;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.huaihsuanhuang.TravelMate.Account.Auth;
import com.huaihsuanhuang.TravelMate.R;

public class Purchase_entrance extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseAuth mAuth;
    TextView purchase_entrance_text;
    private static int Fade_timeout=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_entrance);
        purchase_entrance_text=findViewById(R.id.purchase_entrance_text);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        updateuserstatus(user);
        View view = findViewById(R.id.purchase_entrance);
        view.getBackground().setAlpha(80);



    }



    public void updateuserstatus(FirebaseUser user){
        //  FirebaseUser user = mAuth.getCurrentUser();
        if(user!=null&&user.isEmailVerified()){
            purchase_entrance_text.setText("Welcome "+user.getDisplayName()+",\nnow direct towards the products page.");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent= new Intent(Purchase_entrance.this, Purchase_Home.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

                    finish();
                }
            },Fade_timeout);

        }
        else {
            purchase_entrance_text.setText("This page is logged in and verified required,\nnow direct towards the login page.");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent= new Intent(Purchase_entrance.this, Auth.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

                    finish();
                }
            },Fade_timeout);
        }
    }
}
