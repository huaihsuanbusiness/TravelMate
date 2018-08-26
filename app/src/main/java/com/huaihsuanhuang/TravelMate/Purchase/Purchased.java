package com.huaihsuanhuang.TravelMate.Purchase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.huaihsuanhuang.TravelMate.Adapter.PurchasedAdapter;
import com.huaihsuanhuang.TravelMate.R;
import com.huaihsuanhuang.TravelMate.model.Purchased_model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Purchased extends AppCompatActivity {

    private DatabaseReference rootRef;
    private DatabaseReference databaserequest;
    private RecyclerView purchased_recyclerview;
    private LinearLayoutManager linearLayoutManager;
    private PurchasedAdapter mAdapter;
    private List<Purchased_model> purchased_modelList;
    private FirebaseAuth mAuth;

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
        databaserequest = rootRef.child("databaserequest").child(mAuth.getCurrentUser().getUid());
        final Cart cart = new Cart();
        //    databaserequest.addValueEventListener(new ValueEventListener() {
        //TODO 沒跑進來 recyclerview無法顯示
        //        @Override
        //        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        for (String time : cart.formattedTime_array) {


            final DatabaseReference productlistref = databaserequest.child(time).child("productlist");


            productlistref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.hasChild("0")) {

                            collectproductlist((Map<String, Object>) Objects.requireNonNull(dataSnapshot.getValue()));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }

//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//
//            }
//        });
//
//    }

    private void collectproductlist(Map<String, Object> productlist) {
        for (Map.Entry<String, Object> entry : productlist.entrySet()) {

            Map singleItem = (Map) entry.getValue();
            String name = (String) singleItem.get("product_name");
            String price = (String) singleItem.get("product_price");
            String quantity = (String) singleItem.get("product_quantity");
            purchased_modelList.add(new Purchased_model(name, price, quantity));
            mAdapter.notifyDataSetChanged();
        }


    }
}

