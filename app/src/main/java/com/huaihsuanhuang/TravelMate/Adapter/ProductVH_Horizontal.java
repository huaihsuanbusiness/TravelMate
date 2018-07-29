package com.huaihsuanhuang.TravelMate.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huaihsuanhuang.TravelMate.model.Itemonclicklistener;
import com.huaihsuanhuang.TravelMate.R;

public class ProductVH_Horizontal extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView product_name_horizontal;
    public ImageView product_image_horizontal;
    private Itemonclicklistener itemonclicklistener;

    public ProductVH_Horizontal(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        product_image_horizontal=itemView.findViewById(R.id.card_horizontal_image);
        product_name_horizontal=itemView.findViewById(R.id.card_horizontal_title);
    }
    public void setItemonclicklistener(Itemonclicklistener itemonclicklistener) {
        this.itemonclicklistener = itemonclicklistener;
    }
    @Override
    public void onClick(View view) {
        itemonclicklistener.onClick(view,getAdapterPosition(),false);
    }
}
