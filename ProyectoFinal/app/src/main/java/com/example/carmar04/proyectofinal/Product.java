package com.example.carmar04.proyectofinal;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class Product implements Serializable {

    String ProductName;
    String ProductStock;
    double ProductPrice;
    int ProductImage;

    public Product(String ProductName, String ProductStock, double ProductPrice, int ProductImage){
        this.ProductName = ProductName;
        this.ProductStock = ProductStock;
        this.ProductPrice = ProductPrice;
        this.ProductImage = ProductImage;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }

    public int getProductImage() {
        return ProductImage;
    }

    public void setProductImage(int productImage) {
        ProductImage = productImage;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductStock() {
        return ProductStock;
    }

    public void setProductStock(String productStock) {
        ProductStock = productStock;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(float productPrice) {
        ProductPrice = productPrice;
    }
    @NonNull
    public String toString(){
        return "Producto: " + this.ProductName;
    }
}
