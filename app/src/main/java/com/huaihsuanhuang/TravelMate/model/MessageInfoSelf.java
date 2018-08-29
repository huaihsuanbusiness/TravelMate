package com.huaihsuanhuang.TravelMate.model;


public class MessageInfoSelf implements ListItem {
    private String msg_Text;
    private String msg_User;


    public MessageInfoSelf(String msg_Text, String msg_User) {
        this.msg_Text = msg_Text;
        this.msg_User = msg_User;

    }

    public String getMsg_Text() {
        return msg_Text;
    }

    public void setMsg_Text(String msg_Text) {
        this.msg_Text = msg_Text;
    }

    public String getMsg_User() {
        return msg_User;
    }

    public void setMsg_User(String msg_User) {
        this.msg_User = msg_User;
    }

    @Override
    public int getListItemType() {
        return ListItem.TYPE_B;
    }

}