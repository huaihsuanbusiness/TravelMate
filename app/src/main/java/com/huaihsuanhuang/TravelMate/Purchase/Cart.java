package com.huaihsuanhuang.TravelMate.Purchase;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.huaihsuanhuang.TravelMate.Adapter.CartAdapter;
import com.huaihsuanhuang.TravelMate.Database.DatabaseOrder;
import com.huaihsuanhuang.TravelMate.R;
import com.huaihsuanhuang.TravelMate.model.Order;
import com.huaihsuanhuang.TravelMate.model.Requestfirebase;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Cart extends AppCompatActivity {

    RecyclerView cart_recyclerview;
    RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database;
    DatabaseReference databaserequest;
    TextView cart_total;
    Button cart_placeorder;
    List<Order> orderlsit_cart = new ArrayList<>();
    CartAdapter adapter;
    CardView cart_item_cardview;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private EditText newquantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        database = FirebaseDatabase.getInstance();
        databaserequest = database.getReference("databaserequest");

        cart_recyclerview = findViewById(R.id.cart_recyclerview);

        layoutManager = new LinearLayoutManager(this);
        cart_recyclerview.setLayoutManager(layoutManager);
        cart_total = findViewById(R.id.cart_total);
        mAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        cart_placeorder = findViewById(R.id.cart_btn_placeorder);
        cart_placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertdialog();
            }
        });
        cart_item_cardview = findViewById(R.id.cart_item_cardview);

        loadincart();
    }


    private void showAlertdialog() {
        AlertDialog.Builder ad = new AlertDialog.Builder(Cart.this);
        ad.setTitle("Enter required information");
        ad.setMessage("Enter your phone number");
        ad.setIcon(R.drawable.ic_shopping_cart_black_24dp);
        final EditText inputphone = new EditText(Cart.this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        inputphone.setLayoutParams(layoutParams);
        ad.setView(inputphone);
        ad.setPositiveButton("CkeckOut", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Requestfirebase request = new Requestfirebase(
                        user.getEmail(),
                        user.getDisplayName(), cart_total.getText().toString(), orderlsit_cart, inputphone.getText().toString()
                );
                long currentTime = System.currentTimeMillis();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH時mm分ss秒");
                Date date = new Date(currentTime);

                databaserequest.child(formatter.format(date)).setValue(request);
                //    databaserequest.child(String.valueOf(System.currentTimeMillis())).setValue(request);
                new DatabaseOrder(getBaseContext()).clearcart();
                Toast.makeText(Cart.this, "Order Placed", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        ad.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ad.show();
    }
    private void updatecartAlertdialog() {
        AlertDialog.Builder ad = new AlertDialog.Builder(Cart.this);
        ad.setTitle("Update Cart");
        ad.setMessage("Enter new quantity");
        ad.setIcon(R.drawable.ic_shopping_cart_black_24dp);
        newquantity = new EditText(Cart.this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        newquantity.setLayoutParams(layoutParams);
        ad.setView(newquantity);
        ad.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            newquantity.getText().toString();
                Toast.makeText(Cart.this, "Update Successful", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        ad.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ad.show();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        //TODO info.positoin nullpointerexception
        View view = info.targetView;
        String product_id=orderlsit_cart.get(position).getProduct_id();
        switch (item.getItemId()) {

            case R.id.cart_update: {
                updatecartAlertdialog();
                new DatabaseOrder(getBaseContext()).updatecart(newquantity.getText().toString(),product_id);
                return true;
            }
            case R.id.cart_remove: {
                new DatabaseOrder(getBaseContext()).removecart(product_id);
                return true;
            }
        }
        return true;
    }

    private void loadincart() {
        orderlsit_cart = new DatabaseOrder(this).getcart();
        adapter = new CartAdapter(orderlsit_cart, this);
        cart_recyclerview.setAdapter(adapter);
        registerForContextMenu(cart_recyclerview);


        int total = 0;
        for (Order order : orderlsit_cart) {

            total += (Integer.parseInt(order.getProduct_price())) *
                    (Integer.parseInt(order.getProduct_quantity()));
        }
        Locale locale = new Locale("en", "US");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        cart_total.setText(nf.format(total));
    }


}
