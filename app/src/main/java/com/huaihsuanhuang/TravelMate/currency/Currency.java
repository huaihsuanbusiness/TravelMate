package com.huaihsuanhuang.TravelMate.currency;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Currency {

    protected Currency() {
    }

    /**
     * code : EUR
     * alphaCode : EUR
     * numericCode : 978
     * name : Euro
     * rate : 0.02810834418025
     * date : Mon, 30 Jul 2018 00:00:01 GMT
     * inverseRate : 35.576624278802
     */



    @SerializedName("code") private String code;
    @SerializedName("alphaCode") private String alphaCode;
    @SerializedName("numericCode") private String numericCode;
    @SerializedName("name") private String name;
    @SerializedName("rate") private double rate;
    @SerializedName("date") private String date;
    @SerializedName("inverseRate") private double inverseRate;

    public String getCode() { return code;}

    public void setCode(String code) { this.code = code;}

    public String getAlphaCode() { return alphaCode;}

    public void setAlphaCode(String alphaCode) { this.alphaCode = alphaCode;}

    public String getNumericCode() { return numericCode;}

    public void setNumericCode(String numericCode) { this.numericCode = numericCode;}

    public String getName() { return name;}

    public void setName(String name) { this.name = name;}

    public double getRate() { return rate;}

    public void setRate(double rate) { this.rate = rate;}

    public String getDate() { return date;}

    public void setDate(String date) { this.date = date;}

    public double getInverseRate() { return inverseRate;}

    public void setInverseRate(double inverseRate) { this.inverseRate = inverseRate;}

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}