package com.example.user.shoppingbasket;

import java.util.ArrayList;

/**
 * Created by user on 22/11/2016.
 */

public class Discount {

    private Discount discount;
    private ShoppingBasket basket;
    private Item item;

    public Discount() {
    }

    /* do I need to have a basket here?
    Math.floor round down to nearest int so removes 0.5s
     */
    public double bogof(ShoppingBasket basket) {
        double discountAmount;
        double NumItemsToDiscount = Math.floor(basket.individualItemCount(item) / 2);
        discountAmount = (NumItemsToDiscount * item.getPrice());
        return discountAmount;
    }

//    public double totalDiscount() {
//        double totalDiscount = 0;
//        totalDiscount += bogof(basket, item);
//        return totalDiscount;
//    }


}
