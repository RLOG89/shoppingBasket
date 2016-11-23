package com.example.user.shoppingbasket;

import org.junit.Before;
import org.junit.Test;


import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 22/11/2016.
 */

public class ShoppingBasketTest {

    private ShoppingBasket shoppingBasket;
    private Item i = new Item("Fried Chicken", 3.95);
    private Item i2 = new Item("Banana", 0.40);

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
        shoppingBasket.addItemToBasket(i);
        assertEquals(1, shoppingBasket.getBasket().size());
    }

    @Test
    public void canRemoveItemsFromBasket() {
        shoppingBasket.addItemToBasket(i);
        shoppingBasket.removeItemFromBasket(i);
        assertEquals(0, shoppingBasket.getBasket().size());
    }

    @Test
    public void canEmptyBasket() {
        shoppingBasket.addItemToBasket(i);
        shoppingBasket.addItemToBasket(i2);
        assertEquals(2, shoppingBasket.getBasket().size());
        shoppingBasket.EmptyBasket();
        assertEquals(0, shoppingBasket.getBasket().size());
    }

    @Test
    public void canGetIndividualItemCount() {
        shoppingBasket.addItemToBasket(i);
        shoppingBasket.addItemToBasket(i);
        shoppingBasket.addItemToBasket(i2);
        assertEquals(3, shoppingBasket.getBasket().size());
        assertEquals(2, shoppingBasket.individualItemCount(i));
        assertEquals(1, shoppingBasket.individualItemCount(i2));
    }

    @Test
    public void canGetTotalValueBeforeDiscount() {
        shoppingBasket.addItemToBasket(i);
        shoppingBasket.addItemToBasket(i);
        shoppingBasket.addItemToBasket(i2);
        assertEquals(8.30, shoppingBasket.getTotalValueBeforeDiscount());
    }

//    @Test
//    public void canGetTotalValueAfterDiscount() {
//        shoppingBasket.addItemToBasket(i);
//        shoppingBasket.addItemToBasket(i);
//        shoppingBasket.addItemToBasket(i2);
//        assertEquals(4.35, shoppingBasket.getTotalValueAfterDiscount());
//    }
}
