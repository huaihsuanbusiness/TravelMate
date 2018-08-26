package com.huaihsuanhuang.TravelMate.model;

public class Order {

    private String product_id;
    private String product_name;
    private String product_quantity;
    private String product_price;
    private String product_discount;

    public Order() {
    }

    public Order(String product_id, String product_name, String product_quantity, String product_price, String product_discount) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_quantity = product_quantity;
        this.product_price = product_price;
        this.product_discount = product_discount;
    }

    public String getProduct_id() {
        return product_id;
    }

    public Order setProduct_id(String product_id) {
        this.product_id = product_id;
        return this;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_discount() {
        return product_discount;
    }

    public void setProduct_discount(String product_discount) {
        this.product_discount = product_discount;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        return product_id != null ? product_id.equals(order.product_id) : order.product_id == null;
    }

    @Override
    public int hashCode() {
        return product_id != null ? product_id.hashCode() : 0;
    }
}
