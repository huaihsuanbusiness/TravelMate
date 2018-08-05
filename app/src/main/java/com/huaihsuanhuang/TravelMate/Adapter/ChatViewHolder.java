package com.huaihsuanhuang.TravelMate.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.huaihsuanhuang.TravelMate.R;


public class ChatViewHolder extends RecyclerView.ViewHolder {
  public TextView chat_sticker;
  public TextView chat_message;
  public TextView chat_time;

    public ChatViewHolder(View itemView) {
        super(itemView);
        chat_sticker =itemView.findViewById(R.id.chat_sticker);
        chat_message =itemView.findViewById(R.id.chat_message);
        chat_time =itemView.findViewById(R.id.chat_time);

    }

}
