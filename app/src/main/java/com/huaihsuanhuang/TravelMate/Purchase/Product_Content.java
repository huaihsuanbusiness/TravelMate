package com.huaihsuanhuang.TravelMate.Purchase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.huaihsuanhuang.TravelMate.Database.DatabaseOrder;
import com.huaihsuanhuang.TravelMate.R;
import com.huaihsuanhuang.TravelMate.model.Order;
import com.huaihsuanhuang.TravelMate.model.Productdetail;
import com.squareup.picasso.Picasso;

public class Product_Content extends AppCompatActivity {


    TextView product_name, product_price, product_description;
    ImageView product_image;
    CollapsingToolbarLayout product_content_collapsing;
    FloatingActionButton product_content_cartbtn;
    ElegantNumberButton product_content_numberbtn;

    String product_Key = "";

    FirebaseDatabase firebaseDatabase;
    DatabaseReference myref;
    Productdetail currntproductdetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_content);

        firebaseDatabase = FirebaseDatabase.getInstance();
        myref = firebaseDatabase.getReference("detail");
        product_name = findViewById(R.id.product_content_productname);
        product_price = findViewById(R.id.product_content_productprice);
        product_description = findViewById(R.id.product_content_description);
        product_image = findViewById(R.id.product_content_image);
        product_content_cartbtn = findViewById(R.id.product_content_cartbtn);
        product_content_numberbtn = findViewById(R.id.product_content_numberbtn);
        product_content_cartbtn.
                setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           new DatabaseOrder(getBaseContext()).addtocart(new Order(
                                                   currntproductdetail.getId(),
                                                   currntproductdetail.getAname(),
                                                   product_content_numberbtn.getNumber(),
                                                   currntproductdetail.getDprice(),
                                                   currntproductdetail.getEdiscount()
                                           ));

                                           Toast.makeText(Product_Content.this, "Added to cart", Toast.LENGTH_LONG).show();
                                       }
                                   }
                );

        product_content_collapsing = findViewById(R.id.product_content_collapsing);

        product_content_collapsing.setExpandedTitleTextAppearance(R.style.CityExpand);
        product_content_collapsing.setCollapsedTitleTextAppearance(R.style.CollapseAppbar);


        if (getIntent() != null) {

            product_Key = getIntent().getStringExtra("Id");
            if (!(product_Key.isEmpty())) {

                getProductcontent(product_Key);
            }
        }


    }

    private void getProductcontent(String product_id) {
        myref.child(product_id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currntproductdetail = dataSnapshot.getValue(Productdetail.class);
                Picasso.get().load(currntproductdetail.getBimage()).into(product_image);
                product_content_collapsing.setTitle(currntproductdetail.getAname());
                product_price.setText(currntproductdetail.getDprice());
                product_name.setText(currntproductdetail.getAname());
                product_description.setText(currntproductdetail.getCdescrip());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
