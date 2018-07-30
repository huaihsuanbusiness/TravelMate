package com.huaihsuanhuang.TravelMate;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.huaihsuanhuang.TravelMate.model.Itemonclicklistener;
import com.huaihsuanhuang.TravelMate.model.Productdetail;
import com.huaihsuanhuang.TravelMate.Adapter.Productdetailviewholder;
import com.squareup.picasso.Picasso;

public class Purchase_detaillist extends AppCompatActivity {
    String pruductId="";
    FirebaseDatabase firebaseDatabase;
    DatabaseReference detail;

   private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Productdetail,Productdetailviewholder> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_detaillist);

        firebaseDatabase=FirebaseDatabase.getInstance();
        detail=firebaseDatabase.getReference("detail");

        recyclerView=findViewById(R.id.recycler_detaillist);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        if(getIntent()!=null){
            pruductId =getIntent().getStringExtra("productID");
        }
        if (!(pruductId.isEmpty())&& pruductId!=null){
            loadinproduct( pruductId.toString());
        }

    }
    @Override
    protected void onStart() {
        super.onStart();

        adapter.startListening();
    }
    protected void onStop() {
        super.onStop();

        adapter.stopListening();
    }


    private void loadinproduct(String pruductId) {
        FirebaseRecyclerOptions<Productdetail> options =
                new FirebaseRecyclerOptions.Builder<Productdetail>()
                        .setQuery(detail.orderByChild("fmenuId").equalTo(pruductId), Productdetail.class)
                        .build();

        adapter =new FirebaseRecyclerAdapter<Productdetail, Productdetailviewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Productdetailviewholder holder, int position, @NonNull Productdetail model) {
                Log.d("detaildata",model.getAname()+"\n"+model.getBimage());
                holder.product_detail_name.setText(model.getAname());
                Picasso.get().load(model.getBimage()).into(holder.product_detail_image);


                holder.setItemonclicklistener(new Itemonclicklistener() {
                    @Override
                    public void onClick(View view, int position, boolean islongclick) {

                        Intent intent =new Intent(Purchase_detaillist.this,Product_Content.class);
                        intent.putExtra("fmanuId",adapter.getRef(position).getKey());
                        startActivity(intent);

                    }
                });


            }

            @NonNull
            @Override
            public Productdetailviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.product_detail_item, parent, false);
                return new Productdetailviewholder(view);
            }
        };
        recyclerView.setAdapter(adapter);

    }
}
