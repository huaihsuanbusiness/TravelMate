package com.huaihsuanhuang.TravelMate.Purchase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.huaihsuanhuang.TravelMate.Adapter.PurchasedAdapter;
import com.huaihsuanhuang.TravelMate.R;
import com.huaihsuanhuang.TravelMate.model.Purchased_model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Purchased extends AppCompatActivity {

    private DatabaseReference rootRef;
    private Query databaserequest;
    private RecyclerView purchased_recyclerview;
    private LinearLayoutManager linearLayoutManager;
    private PurchasedAdapter mAdapter;
    private List<Purchased_model> purchased_modelList;
    private FirebaseAuth mAuth;
    private Map<String, Object> mMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchased);
        purchased_recyclerview = findViewById(R.id.purchased_recyclerview);
        purchased_modelList = new ArrayList<>();
        mAdapter = new PurchasedAdapter(this, purchased_modelList);
        linearLayoutManager = new LinearLayoutManager(this);
        purchased_recyclerview.setLayoutManager(linearLayoutManager);
        purchased_recyclerview.setAdapter(mAdapter);
        mAuth = FirebaseAuth.getInstance();
        rootRef = FirebaseDatabase.getInstance().getReference();

        // sample hard code
        databaserequest = rootRef.child("databaserequest").child(mAuth.getCurrentUser().getUid()).orderByChild("account").equalTo(mAuth.getCurrentUser().getEmail());

        databaserequest.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                saveinlist(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void saveinlist(DataSnapshot dataSnapshot) {
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            for (DataSnapshot snapshot1 : snapshot.child("productlist").getChildren()) {
                for (DataSnapshot snapshot2 : snapshot1.getChildren()) {
                    mMap.put(snapshot2.getKey(), snapshot2.getValue());
                }
                String product_name = mMap.get("product_name").toString();
                String product_price = mMap.get("product_price").toString();
                String product_quantity = mMap.get("product_quantity").toString();
                String product_discount = mMap.get("product_discount").toString();
                String product_id = mMap.get("product_id").toString();
                purchased_modelList.add(new Purchased_model(product_name, product_price, product_quantity, product_discount, product_id));
                mAdapter.notifyDataSetChanged();



                mMap.clear();
            }


        }
        Log.d("Purchased000", "dataSnapshot.getChildrenCount():" + dataSnapshot.getChildrenCount());
    }
}

