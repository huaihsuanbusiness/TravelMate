package com.huaihsuanhuang.TravelMate.Purchase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.huaihsuanhuang.TravelMate.Adapter.ProductVHHorizontal;
import com.huaihsuanhuang.TravelMate.Adapter.ProductViewHolder;
import com.huaihsuanhuang.TravelMate.R;
import com.huaihsuanhuang.TravelMate.model.Itemonclicklistener;
import com.huaihsuanhuang.TravelMate.model.ProductCategory;
import com.huaihsuanhuang.TravelMate.model.ProductPopular;

public class Purchase_Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference_product;
    DatabaseReference reference_popular;
    TextView header_text;
    RecyclerView recycler_category;
    RecyclerView.LayoutManager layoutManager_drawer;
    FirebaseRecyclerAdapter<ProductCategory, ProductViewHolder> adapter_category;
    RecyclerView recycler_horizontal;
    RecyclerView.LayoutManager layoutManager_horizontal;
    FirebaseRecyclerAdapter<ProductPopular, ProductVHHorizontal> adapter_horizontal;
    FloatingActionButton product_home_cartbutton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        product_home_cartbutton=findViewById(R.id.product_home_cartbutton);
        product_home_cartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cartintent = new Intent(Purchase_Home.this, Cart.class);
                startActivity(cartintent);

            }
        });

        toolbar.setTitle("Products");
        setSupportActionBar(toolbar);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference_product = firebaseDatabase.getReference("product");
        reference_popular = firebaseDatabase.getReference("popular");

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerview = navigationView.getHeaderView(0);
        header_text = headerview.findViewById(R.id.drawer_headertext);
        header_text.setText("Welcome " + user.getDisplayName());

        recycler_category = findViewById(R.id.recyclerview_category);
        //    recycler_category.setHasFixedSize(true);
        layoutManager_drawer = new LinearLayoutManager(this);
        recycler_category.setLayoutManager(layoutManager_drawer);
        recycler_category.setDrawingCacheEnabled(true);
        recycler_category.setItemViewCacheSize(20);
        recycler_category.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recycler_horizontal = findViewById(R.id.recyclerview_horizontal);
        //     recycler_horizontal.setHasFixedSize(true);
        layoutManager_horizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recycler_horizontal.setLayoutManager(layoutManager_horizontal);
        new PagerSnapHelper().attachToRecyclerView(recycler_horizontal);

        loadinproducthorizontal();
        loadinproductcaegory();
    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter_category.startListening();
        adapter_horizontal.startListening();
    }

    protected void onStop() {
        super.onStop();
        adapter_category.stopListening();
        adapter_horizontal.stopListening();
    }

    private void loadinproducthorizontal() {
        FirebaseRecyclerOptions<ProductPopular> options =
                new FirebaseRecyclerOptions.Builder<ProductPopular>()
                        .setQuery(reference_popular, ProductPopular.class)
                        .build();
        adapter_horizontal = new FirebaseRecyclerAdapter<ProductPopular, ProductVHHorizontal>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ProductVHHorizontal holder, int position, @NonNull ProductPopular model) {
                holder.product_name_horizontal.setText(model.getName());
             //   Picasso.get().load(model.getImage()).into(holder.product_image_horizontal);
                Glide.with(Purchase_Home.this)
                        .load(model.getImage())
                        .into(holder.product_image_horizontal);
                holder.setItemonclicklistener(new Itemonclicklistener() {
                    // TODO onclicklistener 沒反應
                    // https://stackoverflow.com/questions/6971836/onclicklistener-doesnt-work-with-clickable-attribute
                    @Override
                    public void onClick(View view, int position, boolean islongclick) {
                        Intent intent = new Intent(Purchase_Home.this, Product_Content.class);
                        intent.putExtra("Id", adapter_horizontal.getRef(position).getKey());
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public ProductVHHorizontal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.horizontal_item, parent, false);
                return new ProductVHHorizontal(view);
            }
        };
        adapter_horizontal.notifyDataSetChanged();
        recycler_horizontal.setAdapter(adapter_horizontal);
        recycler_horizontal.setNestedScrollingEnabled(false);
    }

    private void loadinproductcaegory() {
        FirebaseRecyclerOptions<ProductCategory> options =
                new FirebaseRecyclerOptions.Builder<ProductCategory>()
                        .setQuery(reference_product, ProductCategory.class)
                        .build();
        adapter_category = new FirebaseRecyclerAdapter<ProductCategory, ProductViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull ProductCategory model) {
                Log.d("loadin", model.getImage() + "\n" + model.getName());
                holder.product_name.setText(model.getName());
               // Picasso.get().load(model.getImage()).into(holder.product_image);
                // final ProductCategory clickitem =model;
                Glide.with(Purchase_Home.this)
                        .load(model.getImage())
                        .into(holder.product_image);
                holder.setItemonclicklistener(new Itemonclicklistener() {
                    @Override
                    public void onClick(View view, int position, boolean islongclick) {
                        Intent intent = new Intent(Purchase_Home.this, Purchase_detaillist.class);
                        intent.putExtra("productKey", adapter_category.getRef(position).getKey());
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.product_items, parent, false);

                return new ProductViewHolder(view);
            }
        };
        adapter_category.notifyDataSetChanged();
        recycler_category.setAdapter(adapter_category);
        recycler_category.setNestedScrollingEnabled(false);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Purchase_Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_explore) {

        } else if (id == R.id.nav_wishlist) {

        } else if (id == R.id.nav_cart) {
            Intent cartintent_drawer = new Intent(Purchase_Home.this, Cart.class);
            startActivity(cartintent_drawer);

        } else if (id == R.id.nav_ordered) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
