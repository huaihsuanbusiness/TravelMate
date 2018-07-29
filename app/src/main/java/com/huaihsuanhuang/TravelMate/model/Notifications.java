package com.huaihsuanhuang.TravelMate.model;

public class Notifications {

    private String noti_subject;
    private String noti_content;
    private String noti_update;


    public Notifications(String noti_subject, String noti_content, String noti_update) {

        this.noti_subject = noti_subject;
        this.noti_content = noti_content;
        this.noti_update = noti_update;
    }

    public String getNoti_subject() {
        return noti_subject;
    }

    public void setNoti_subject(String noti_subject) {
        this.noti_subject = noti_subject;
    }

    public String getNoti_content() {
        return noti_content;
    }

    public void setNoti_content(String noti_content) {
        this.noti_content = noti_content;
    }

    public String getNoti_update() {
        return noti_update;
    }

    public void setNoti_update(String noti_update) {
        this.noti_update = noti_update;
    }
}

