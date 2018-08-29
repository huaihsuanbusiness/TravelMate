package com.huaihsuanhuang.TravelMate.model;


public class MessageInfo implements ListItem {
    private String text;
    private String user;
    private String time;

    public MessageInfo(String text, String user, String time) {
        this.text = text;
        this.user = user;
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int getListItemType() {
        return ListItem.TYPE_A;
    }

}