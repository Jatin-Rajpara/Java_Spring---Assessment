package com.jatin.model;

public class Order {

    int rId;
    String iName;
    int qty;
    String cName;

    public Order() {

    }

    public Order(int rId, String iName, int qty, String cName) {
        this.rId = rId;
        this.iName = iName;
        this.qty = qty;
        this.cName = cName;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}