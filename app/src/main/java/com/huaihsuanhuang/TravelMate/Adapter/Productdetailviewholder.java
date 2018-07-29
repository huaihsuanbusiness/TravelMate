package com.huaihsuanhuang.TravelMate.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huaihsuanhuang.TravelMate.model.Itemonclicklistener;
import com.huaihsuanhuang.TravelMate.R;

public class Productdetailviewholder extends RecyclerviewAdapter.RecyclerViewHolder implements View.OnClickListener {
    public TextView product_detail_name;
    public ImageView product_detail_image;
    private Itemonclicklistener itemonclicklistener;

    public void setItemonclicklistener(Itemonclicklistener itemonclicklistener) {
        this.itemonclicklistener = itemonclicklistener;
    }

    public Productdetailviewholder(View itemView) {
        super(itemView);


        product_detail_image=itemView.findViewById(R.id.product_detail_background);
        product_detail_name=itemView.findViewById(R.id.product_detail_title);
        itemView.setOnClickListener(this);
}



    @Override
    public void onClick(View v) {
itemonclicklistener.onClick(v,getAdapterPosition(),false);
    }


}
