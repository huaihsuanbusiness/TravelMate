package com.huaihsuanhuang.TravelMate.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.huaihsuanhuang.TravelMate.R;
import com.huaihsuanhuang.TravelMate.model.Purchased_model;

import java.util.List;

public class PurchasedAdapter extends RecyclerView.Adapter<PurchasedAdapter.PurchasedViewHolder> {

    Context context;
    List<Purchased_model> purchased_modelList;

    public PurchasedAdapter(Context context, List<Purchased_model> purchased_modelList) {
        this.context = context;
        this.purchased_modelList = purchased_modelList;
    }

    @NonNull
    @Override
    public PurchasedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.cart_items, parent, false);
        return new PurchasedAdapter.PurchasedViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull PurchasedViewHolder holder, int position) {
        holder.cart_item_name.setText(purchased_modelList.get(position).getProduct_name());
        holder.cart_item_price.setText(purchased_modelList.get(position).getProduct_price());
        TextDrawable textDrawable = TextDrawable.builder().buildRound(" " + purchased_modelList.get(position).getProduct_quantity(), Color.BLUE);
        holder.cart_count.setImageDrawable(textDrawable);


    }


    @Override
    public int getItemCount() {
        return purchased_modelList.size();
    }

    static class PurchasedViewHolder extends RecyclerView.ViewHolder {


        TextView cart_item_name, cart_item_price;
        ImageView cart_count;


        PurchasedViewHolder(View itemView) {
            super(itemView);
            cart_item_name = itemView.findViewById(R.id.cart_item_name);
            cart_item_price = itemView.findViewById(R.id.cart_item_price);
            cart_count = itemView.findViewById(R.id.cart_count);

        }
    }
}
