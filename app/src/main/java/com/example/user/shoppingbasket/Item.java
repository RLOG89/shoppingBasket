package com.example.user.shoppingbasket;

/**
 * Created by user on 22/11/2016.
 */

public class Item {

    private String name;
    private double price;
    private boolean bogof;

    public Item(String name, double price, boolean bogof) {
        this.name = name;
        this.price = price;
        this.bogof = bogof;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBogof() {
        return bogof;
    }
}
