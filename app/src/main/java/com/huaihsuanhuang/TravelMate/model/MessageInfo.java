package com.huaihsuanhuang.TravelMate.model;


import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageInfo {
    private String msg_Text;
    private String msg_User;
 //   private long msg_Time;



    public MessageInfo(String msg_Text, String msg_User) {
        this.msg_Text = msg_Text;
        this.msg_User = msg_User;
       // msg_Time =  System.currentTimeMillis();
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
//
//    public long getMsg_Time() {
//        return msg_Time;
//    }
//
//    public void setMsg_Time(long msg_Time) {
//        this.msg_Time = msg_Time;
//    }
}