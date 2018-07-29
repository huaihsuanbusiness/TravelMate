package com.huaihsuanhuang.TravelMate.model;

import android.os.Parcel;
import android.os.Parcelable;

public class City implements Parcelable{

    private String Title;
    private String Description;
    private String Access;
    private String Tourism;
    private String Thumbnail;

    public City(String title, String description, String access, String tourism, String  thumbnail) {
        Title = title;
        Description = description;
        Access = access;
        Tourism = tourism;
        Thumbnail = thumbnail;
    }



    protected City(Parcel in) {
        Title = in.readString();
        Description = in.readString();
        Access = in.readString();
        Tourism = in.readString();
        Thumbnail = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Title);
        dest.writeString(Description);
        dest.writeString(Access);
        dest.writeString(Tourism);
        dest.writeString(Thumbnail);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getIntroduction() {
        return Description;
    }

    public void setIntroduction(String introduction) {
        Description = introduction;
    }



    public String getAccess() {
        return Access;
    }

    public void setAccess(String access) {
        Access = access;
    }

    public String getTourism() {
        return Tourism;
    }

    public void setTourism(String tourism) {
        Tourism = tourism;
    }

    public String  getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(String  thumbnail) {
        Thumbnail = thumbnail;
    }
}
