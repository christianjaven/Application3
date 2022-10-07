package com.example.myapplication.model;

public class CartModel {
    private String key,name,image,price;
    private int quantity;
    private float totalPrice;

    public CartModel() {
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
