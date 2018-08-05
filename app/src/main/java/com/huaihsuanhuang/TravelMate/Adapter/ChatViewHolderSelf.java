package com.huaihsuanhuang.TravelMate.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.huaihsuanhuang.TravelMate.R;

public class ChatViewHolderSelf extends RecyclerView.ViewHolder {
    public TextView chat_sticker_self;
    public TextView chat_message_self;
    public TextView chat_time_self;

    public ChatViewHolderSelf(View itemView) {
        super(itemView);
        chat_sticker_self =itemView.findViewById(R.id.chat_sticker_self);
        chat_message_self =itemView.findViewById(R.id.chat_message_self);
        chat_time_self =itemView.findViewById(R.id.chat_time_self);

    }}
