package com.huaihsuanhuang.TravelMate;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class Databasetest_new extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    private ArrayList<String> notelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databasetest_new);
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        DatabaseReference myRef1 =FirebaseDatabase.getInstance().getReference("note");

        //      myRef.addListenerForSingleValueEvent(new ValueEventListener() {
        myRef1.child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                notelist = new ArrayList<>();

                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    notelist.add(String.valueOf(dsp.getValue()));

                    }

                for (int i=0;i<notelist.size();i++){

                  String con1= notelist.get(0);
                  String sub1 =notelist.get(1);
                  String tit1 =notelist.get(2);
                  String upd1 =notelist.get(3);

             //     Log.d("con1",con1+"\n"+sub1+"\n"+tit1+"\n"+upd1);
                }


            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

    }
}
