package com.example.carmar04.proyectofinal;

import java.io.Serializable;

public class Orders implements Serializable {

    int OrderId;
    int OrderUserId;
    int OrderArticles;
    double OrderAmount;

    public Orders(int OrderId, int OrderUserId, int OrderArticles, double OrderAmount){
        this.OrderId = OrderId;
        this.OrderUserId = OrderUserId;
        this.OrderArticles = OrderArticles;
        this.OrderAmount = OrderAmount;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public int getOrderUserId() {
        return OrderUserId;
    }

    public void setOrderUserId(int orderUserId) {
        OrderUserId = orderUserId;
    }

    public int getOrderArticles() {
        return OrderArticles;
    }

    public void setOrderArticles(int orderArticles) {
        OrderArticles = orderArticles;
    }

    public double getOrderAmount() {
        return OrderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        OrderAmount = orderAmount;
    }

}
