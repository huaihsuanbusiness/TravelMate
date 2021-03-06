package com.huaihsuanhuang.TravelMate.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huaihsuanhuang.TravelMate.R;
import com.huaihsuanhuang.TravelMate.model.Notifications;

import java.util.List;

public class RecyclerviewAdapterNotification extends RecyclerView.Adapter<RecyclerviewAdapterNotification.RecyclerViewHolder> {
    private Context mContext;
    private List<Notifications> mNotification;

    public RecyclerviewAdapterNotification(Context mContext, List<Notifications> mNotification) {
        this.mContext = mContext;
        this.mNotification = mNotification;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
//        Context mContext = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.notification_items, parent, false);


        return new RecyclerViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.noti_subject.setText(mNotification.get(position).getNoti_subject());
        holder.noti_content.setText(mNotification.get(position).getNoti_content());
        holder.noti_update.setText(mNotification.get(position).getNoti_update());

    }

    @Override
    public int getItemCount() {
        return mNotification.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {


        TextView noti_subject;
        TextView noti_content;
        TextView noti_update;
        CardView noti_carditem;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            noti_subject = itemView.findViewById(R.id.noti_text_subject);
            noti_content = itemView.findViewById(R.id.noti_text_content);
            noti_update = itemView.findViewById(R.id.noti_text_update);
            noti_carditem = itemView.findViewById(R.id.noti_carditem);
        }

    }

}
