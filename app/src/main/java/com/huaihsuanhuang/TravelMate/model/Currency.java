package com.huaihsuanhuang.TravelMate.model;

import com.google.gson.GsonBuilder;

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



    private String code;
    private String alphaCode;
    private String numericCode;
    private String name;
    private double rate;
    private String date;
    private double inverseRate;

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
