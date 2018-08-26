package com.huaihsuanhuang.TravelMate.model;

public class Purchased_model {
    private String product_name;
    private String product_price;
    private String product_quantity;


    public Purchased_model(String purchased_product_name, String purchased_product_price, String purchased_product_quantity) {
        this.product_name = purchased_product_name;
        this.product_price = purchased_product_price;
        this.product_quantity = purchased_product_quantity;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }
}
