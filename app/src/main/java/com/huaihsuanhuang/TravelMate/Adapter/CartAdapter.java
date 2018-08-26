package com.huaihsuanhuang.TravelMate.Adapter;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.huaihsuanhuang.TravelMate.R;
import com.huaihsuanhuang.TravelMate.model.Itemonclicklistener;
import com.huaihsuanhuang.TravelMate.model.Order;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


class CartViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

    public TextView cart_item_name;
    public TextView cart_item_price;
    public ImageView cart_count;
    public CardView cart_item_cardview;
    private Itemonclicklistener itemonclicklistener;
    private int position;



    public void setPosition(int position) {
        this.position = position;
    }

    public void setCart_item_name(TextView cart_item_name) {
        this.cart_item_name = cart_item_name;
    }

    public CartViewHolder(View itemView) {
        super(itemView);
        cart_item_name = itemView.findViewById(R.id.cart_item_name);
        cart_item_price = itemView.findViewById(R.id.cart_item_price);
        cart_count = itemView.findViewById(R.id.cart_count);
        cart_item_cardview = itemView.findViewById(R.id.cart_item_cardview);
        itemView.setOnCreateContextMenuListener(this);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.add(0, R.id.cart_update, 0, "Update");
        menu.add(0, R.id.cart_remove, 1, "Remove");

    }

}

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {
    @NonNull
    private List<Order> listdata;
    private Context context;

    public CartAdapter(@NonNull List<Order> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;

    }


    @NonNull
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.cart_items, parent, false);

        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartViewHolder holder, final int position) {
        TextDrawable textDrawable = TextDrawable.builder().buildRound(" " + listdata.get(position).getProduct_quantity(), Color.BLUE);
        holder.cart_count.setImageDrawable(textDrawable);

        Locale locale = new Locale("en", "US");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        int price = (Integer.parseInt(listdata.get(position).getProduct_price())) *
                (Integer.parseInt(listdata.get(position).getProduct_quantity()));
        holder.cart_item_price.setText(nf.format(price));
        holder.cart_item_name.setText(listdata.get(position).getProduct_name());

    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }
}
