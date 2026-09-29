package com.jatin.model;

public class Order {

    int orderId;
    String customerName;
    String restaurantName;
    double totalAmount;
    String status;

    public Order() {

    }

    public Order(int orderId, String customerName, String restaurantName,
                 double totalAmount, String status) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.restaurantName = restaurantName;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}