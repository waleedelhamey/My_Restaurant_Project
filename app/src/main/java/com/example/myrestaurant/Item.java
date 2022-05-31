package com.example.myrestaurant;

import android.widget.ImageView;

import java.io.Serializable;

public class Item implements Serializable {
    String name,description;
    double price;
    int itemImg,quantity;


    public Item() {
    }

    public Item( String name,String description, double price,int itemImg) {
        this.name = name;
        this.price = price;
        this.description=description;
        this.itemImg = itemImg;
        quantity = 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemImg() {
        return itemImg;
    }

    public void setItemImg(int itemImg) {
        this.itemImg = itemImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
