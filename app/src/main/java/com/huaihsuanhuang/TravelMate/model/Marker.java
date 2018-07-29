package com.huaihsuanhuang.TravelMate.model;

public class Marker {

    String title;
    Double longitude;
    Double latitude;

    public Marker(String title, Double longitude, Double latitude) {
        this.title = title;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}