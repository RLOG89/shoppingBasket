package com.example.user.shoppingbasket;

import org.junit.Before;
import org.junit.Test;


import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 22/11/2016.
 */

public class ShoppingBasketTest {

    private ShoppingBasket shoppingBasket;
    private Item i1 = new Item("Fried Chicken", 3.95, true);
    private Item i2 = new Item("Banana", 0.40, false);
    private Customer c1 = new Customer("Bill", true);
    private Customer c2 = new Customer("John", false);

    @Before
    public void before() {
    shoppingBasket = new ShoppingBasket();
    }

    @Test
    public void basketStartsEmpty() {
        assertEquals(0,  shoppingBasket.getBasket().size());
    }

    @Test
    public void canAddItemsToBasket() {
        shoppingBasket.addItemToBasket(i1);
        assertEquals(1, shoppingBasket.getBasket().size());
    }

    @Test
    public void canRemoveItemsFromBasket() {
        shoppingBasket.addItemToBasket(i1);
        shoppingBasket.removeItemFromBasket(i1);
        assertEquals(0, shoppingBasket.getBasket().size());
    }

    @Test
    public void canEmptyBasket() {
        shoppingBasket.addItemToBasket(i1);
        shoppingBasket.addItemToBasket(i2);
        assertEquals(2, shoppingBasket.getBasket().size());
        shoppingBasket.EmptyBasket();
        assertEquals(0, shoppingBasket.getBasket().size());
    }

    @Test
    public void canGetIndividualItemCount() {
        shoppingBasket.addItemToBasket(i1);
        shoppingBasket.addItemToBasket(i1);
        shoppingBasket.addItemToBasket(i2);
        assertEquals(3, shoppingBasket.getBasket().size());
        assertEquals(2, shoppingBasket.individualItemCount(i1));
        assertEquals(1, shoppingBasket.individualItemCount(i2));
    }

    @Test
    public void bogofWorks() {
        shoppingBasket.addItemToBasket(i1);
        shoppingBasket.addItemToBasket(i1);
        shoppingBasket.addItemToBasket(i1);
        shoppingBasket.addItemToBasket(i2);
        shoppingBasket.addItemToBasket(i2);
        assertEquals(8.70, shoppingBasket.getTotalPrice(), 0.01);
    }

    @Test
    public void totalPriceAfterDiscountCorrect1() {
        for (int i = 0; i < 7; i ++) {
            shoppingBasket.addItemToBasket(i1);
        }
        for (int i = 0; i < 3; i++) {
            shoppingBasket.addItemToBasket(i2);
        }
        assertEquals(10, shoppingBasket.getBasket().size());
        assertEquals(17, shoppingBasket.getNetBill(c1), 0.01);
        assertEquals(17, shoppingBasket.getNetBill(c2), 0.01);
    }

    @Test
    public void totalPriceAfterDiscountCorrectWithLoyaltyCard() {
        for (int i = 0; i < 11; i ++) {
            shoppingBasket.addItemToBasket(i1);
        }
        for (int i = 0; i < 3; i++) {
            shoppingBasket.addItemToBasket(i2);
        }
        assertEquals(14, shoppingBasket.getBasket().size());
        assertEquals(24.90, shoppingBasket.getTotalPrice(), 0.01);
        assertEquals(21.96, shoppingBasket.getNetBill(c1), 0.01);
    }

    @Test
    public void totalPriceAfterDiscountCorrectWithNoLoyaltyCard() {
        for (int i = 0; i < 11; i++) {
            shoppingBasket.addItemToBasket(i1);
        }
        for (int i = 0; i < 3; i++) {
            shoppingBasket.addItemToBasket(i2);
        }
        assertEquals(14, shoppingBasket.getBasket().size());
        assertEquals(24.90, shoppingBasket.getTotalPrice(), 0.01);
        assertEquals(22.41, shoppingBasket.getNetBill(c2), 0.01);
    }

    @Test
    public void removingItemRemovesBogofCorrectly() {
        for (int i = 0; i < 3; i ++) {
            shoppingBasket.addItemToBasket(i1);
        }
        for (int i = 0; i < 3; i++) {
            shoppingBasket.addItemToBasket(i2);
        }
        shoppingBasket.removeItemFromBasket(i1);
        shoppingBasket.removeItemFromBasket(i2);
        assertEquals(8.70, shoppingBasket.getTotalPrice(), 0.01);
        shoppingBasket.addItemToBasket(i1);
        assertEquals(12.65, shoppingBasket.getTotalPrice(), 0.01);
        shoppingBasket.addItemToBasket(i1);
        assertEquals(12.65, shoppingBasket.getTotalPrice(), 0.01);
    }

}
