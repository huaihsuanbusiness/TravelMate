package com.huaihsuanhuang.TravelMate.model;

public class Purchased_model {
    public String purchased_product_name;
    public String purchased_product_price;
    public String purchased_product_quantity;


    public Purchased_model(String purchased_product_name, String purchased_product_price, String purchased_product_quantity) {
        this.purchased_product_name = purchased_product_name;
        this.purchased_product_price = purchased_product_price;
        this.purchased_product_quantity = purchased_product_quantity;
    }

    public String getPurchased_product_name() {
        return purchased_product_name;
    }

    public void setPurchased_product_name(String purchased_product_name) {
        this.purchased_product_name = purchased_product_name;
    }

    public String getPurchased_product_price() {
        return purchased_product_price;
    }

    public void setPurchased_product_price(String purchased_product_price) {
        this.purchased_product_price = purchased_product_price;
    }

    public String getPurchased_product_quantity() {
        return purchased_product_quantity;
    }

    public void setPurchased_product_quantity(String purchased_product_quantity) {
        this.purchased_product_quantity = purchased_product_quantity;
    }
}
