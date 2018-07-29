package com.huaihsuanhuang.TravelMate.Adapter;

import android.view.View;
import android.widget.TextView;

import com.huaihsuanhuang.TravelMate.R;

public class NotificationViewHolder extends RecyclerviewAdapter.RecyclerViewHolder {
    public TextView subject_noti;
    public TextView content_noti;
    public TextView update_noti;

    public NotificationViewHolder(View itemView) {
        super(itemView);

        subject_noti=itemView.findViewById(R.id.noti_text_subject);
        content_noti=itemView.findViewById(R.id.noti_text_content);
        update_noti=itemView.findViewById(R.id.noti_text_update);

    }




}
