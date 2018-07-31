package com.huaihsuanhuang.TravelMate.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.huaihsuanhuang.TravelMate.MainPage.CityContent;
import com.huaihsuanhuang.TravelMate.MainPage.FragmentHome;
import com.huaihsuanhuang.TravelMate.Purchase.Purchase_Home;
import com.huaihsuanhuang.TravelMate.model.City;
import com.huaihsuanhuang.TravelMate.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.RecyclerViewHolder> {

    private Context mContext;
    private List<City> mCityList;

    public RecyclerviewAdapter(Context mContext, List<City> mCityList) {
        this.mContext = mContext;
        this.mCityList = mCityList;
    }



    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
       // LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater layoutInflater =LayoutInflater.from(mContext);
        view= layoutInflater.inflate(R.layout.city_items,parent,false);
        return new RecyclerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position) {
       // Picasso.get().load(mCityList.get(position).getThumbnail()).into(holder.city_image_imageview);
        Glide.with(this.mContext)
                .load(mCityList.get(position).getThumbnail())
                .into(holder.city_image_imageview);
        holder.city_title_textview.setText(mCityList.get(position).getTitle());

        holder.city_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,CityContent.class);

                intent.putExtra("City",mCityList.get(position));

                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mCityList.size();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder{


        TextView city_title_textview;
        ImageView city_image_imageview;
        CardView city_cardview;

        RecyclerViewHolder(View itemView) {
            super(itemView);
            city_title_textview=  itemView.findViewById(R.id.card_title_one);
            city_image_imageview= itemView.findViewById(R.id.card_image_one);
            city_cardview = itemView.findViewById(R.id.cardview_id);
        }
    }
    

}
