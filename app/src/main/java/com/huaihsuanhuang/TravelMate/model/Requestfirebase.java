package com.huaihsuanhuang.TravelMate.model;

import java.util.List;

public class Requestfirebase {

    private String account;
    private String displayname;
    private String total;
    private List<Order> productlist;
    private String phone;

    public Requestfirebase(String account, String displayname, String total, List<Order> productlist, String phone) {
        this.account = account;
        this.displayname = displayname;
        this.total = total;
        this.productlist = productlist;
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Order> getProductlist() {
        return productlist;
    }

    public void setProductlist(List<Order> productlist) {
        this.productlist = productlist;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
