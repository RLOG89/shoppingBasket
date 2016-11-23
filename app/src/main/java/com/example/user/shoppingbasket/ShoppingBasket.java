package com.example.user.shoppingbasket;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 22/11/2016.
 */

public class ShoppingBasket {

    private ArrayList<Item> basket;
    private Discount discount;
    private Item item;

    public ShoppingBasket() {
        this.basket = new ArrayList<>();
    }

    public ArrayList<Item> getBasket() {
        return basket;
    }

    public void addItemToBasket(Item item) {
        this.basket.add(item);
    }

    public void removeItemFromBasket(Item item) {
        this.basket.remove(item);
    }

    public void EmptyBasket() {
        this.basket.clear();
    }

    public int individualItemCount(Item item) {
        int itemCount = Collections.frequency(basket, item);
        return itemCount;
    }

    public double getTotalValueBeforeDiscount() {
        double totalValue = 0;
        for (Item eachItem : basket) {
            totalValue += (eachItem.getPrice());
            }
        return totalValue;
        }

    //fix this //
//    public double getTotalValueAfterDiscount() {
//        double initialValue = getTotalValueBeforeDiscount();
//        return initialValue - discount.totalDiscount();
//    }
}
