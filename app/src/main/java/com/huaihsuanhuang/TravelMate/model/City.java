package com.huaihsuanhuang.TravelMate.model;

import android.os.Parcel;
import android.os.Parcelable;

public class City
        implements Parcelable
        {

    private String Title;
    private String Thumbnail;
    private String Description;

    private String city_data1;
    private String city_data2;
    private String city_data3;
    private String city_data4;
    private String city_data5;
    private String city_data6;
    private String city_data7;
    private String city_data8;
    private String city_data9;
    private String city_data10;

            public City(String title, String thumbnail, String description, String city_data1, String city_data2, String city_data3, String city_data4, String city_data5, String city_data6, String city_data7, String city_data8, String city_data9, String city_data10) {
                Title = title;
                Thumbnail = thumbnail;
                Description = description;
                this.city_data1 = city_data1;
                this.city_data2 = city_data2;
                this.city_data3 = city_data3;
                this.city_data4 = city_data4;
                this.city_data5 = city_data5;
                this.city_data6 = city_data6;
                this.city_data7 = city_data7;
                this.city_data8 = city_data8;
                this.city_data9 = city_data9;
                this.city_data10 = city_data10;
            }

            protected City(Parcel in) {
        Title = in.readString();
        Thumbnail = in.readString();
        Description = in.readString();
        city_data1 = in.readString();
        city_data2 = in.readString();
                city_data3 = in.readString();
                city_data4 = in.readString();
                city_data5 = in.readString();
                city_data6 = in.readString();
                city_data7 = in.readString();
                city_data8 = in.readString();
                city_data9 = in.readString();
                city_data10 = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Title);
        dest.writeString(Thumbnail);
        dest.writeString(Description);
        dest.writeString(city_data1);
        dest.writeString(city_data2);
        dest.writeString(city_data3);
        dest.writeString(city_data4);
        dest.writeString(city_data5);
        dest.writeString(city_data6);
        dest.writeString(city_data7);
        dest.writeString(city_data8);
        dest.writeString(city_data9);
        dest.writeString(city_data10);


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

            public String getThumbnail() {
                return Thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                Thumbnail = thumbnail;
            }

            public String getDescription() {
                return Description;
            }

            public void setDescription(String description) {
                Description = description;
            }

            public String getCity_data1() {
                return city_data1;
            }

            public void setCity_data1(String city_data1) {
                this.city_data1 = city_data1;
            }

            public String getCity_data2() {
                return city_data2;
            }

            public void setCity_data2(String city_data2) {
                this.city_data2 = city_data2;
            }

            public String getCity_data3() {
                return city_data3;
            }

            public void setCity_data3(String city_data3) {
                this.city_data3 = city_data3;
            }

            public String getCity_data4() {
                return city_data4;
            }

            public void setCity_data4(String city_data4) {
                this.city_data4 = city_data4;
            }

            public String getCity_data5() {
                return city_data5;
            }

            public void setCity_data5(String city_data5) {
                this.city_data5 = city_data5;
            }

            public String getCity_data6() {
                return city_data6;
            }

            public void setCity_data6(String city_data6) {
                this.city_data6 = city_data6;
            }

            public String getCity_data7() {
                return city_data7;
            }

            public void setCity_data7(String city_data7) {
                this.city_data7 = city_data7;
            }

            public String getCity_data8() {
                return city_data8;
            }

            public void setCity_data8(String city_data8) {
                this.city_data8 = city_data8;
            }

            public String getCity_data9() {
                return city_data9;
            }

            public void setCity_data9(String city_data9) {
                this.city_data9 = city_data9;
            }

            public String getCity_data10() {
                return city_data10;
            }

            public void setCity_data10(String city_data10) {
                this.city_data10 = city_data10;
            }

            public static Creator<City> getCREATOR() {
                return CREATOR;
            }
        }
