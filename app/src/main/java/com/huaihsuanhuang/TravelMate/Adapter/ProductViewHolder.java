package com.huaihsuanhuang.TravelMate.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huaihsuanhuang.TravelMate.R;
import com.huaihsuanhuang.TravelMate.model.Itemonclicklistener;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public TextView product_name;
    public ImageView product_image;
    private Itemonclicklistener itemonclicklistener;

    public ProductViewHolder(final View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        product_image = itemView.findViewById(R.id.product_item_background);
        product_name = itemView.findViewById(R.id.product_item_title);

    }

    public void setItemonclicklistener(Itemonclicklistener itemonclicklistener) {
        this.itemonclicklistener = itemonclicklistener;
    }


    @Override
    public void onClick(View v) {
        itemonclicklistener.onClick(v, getAdapterPosition(), false);
    }
}
