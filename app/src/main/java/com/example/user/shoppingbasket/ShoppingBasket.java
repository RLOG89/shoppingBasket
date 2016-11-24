package com.example.user.shoppingbasket;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 22/11/2016.
 */

public class ShoppingBasket {

    private ArrayList<Item> basket;
    private double totalPrice;

    public ShoppingBasket() {
        this.basket = new ArrayList<>();
        this.totalPrice = 0.00;
    }

    public ArrayList<Item> getBasket() {
        return basket;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addItemToBasket(Item item) {
        if (item.isBogof() && basket.contains(item)) {
            int itemCount = Collections.frequency(basket, item);
            if (itemCount % 2 == 0) {
                totalPrice += item.getPrice();
            }
        }
        else totalPrice += item.getPrice();
        this.basket.add(item);
    }

    public void removeItemFromBasket(Item item) {
        if (item.isBogof() && basket.contains(item)) {
            int itemCount = Collections.frequency(basket, item);
            if (itemCount % 2 == 0) {
                totalPrice -= item.getPrice();
            }
        }
        else totalPrice -= item.getPrice();
        this.basket.remove(item);
    }

    public void EmptyBasket() {
        this.basket.clear();
        this.totalPrice = 0.00;
    }

    public int individualItemCount(Item item) {
        int itemCount = Collections.frequency(basket, item);
        return itemCount;
    }

    public double getNetBill(Customer customer) {
        if (this.totalPrice > 20.00) {
            totalPrice *= 0.9;
            if (customer.hasLoyaltyCard()) {
                totalPrice *= 0.98;
            }
        }
        return totalPrice;
    }

}
