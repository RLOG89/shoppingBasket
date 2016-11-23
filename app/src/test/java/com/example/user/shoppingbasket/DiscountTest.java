package com.example.user.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 22/11/2016.
 */

public class DiscountTest {

    private Discount discount;
    private ShoppingBasket shoppingBasket;
    private Item i = new Item("Fried Chicken", 3.95);
    private Item i2 = new Item("Banana", 0.40);


    @Before
    public void before() {
        this.shoppingBasket = new ShoppingBasket();
        this.discount = new Discount();
    }

    @Test
    public void bogofWorks() {
        shoppingBasket.addItemToBasket(i);
        shoppingBasket.addItemToBasket(i);
        shoppingBasket.addItemToBasket(i);
        shoppingBasket.addItemToBasket(i);
        shoppingBasket.addItemToBasket(i);
        shoppingBasket.addItemToBasket(i2);
        shoppingBasket.addItemToBasket(i2);
        shoppingBasket.addItemToBasket(i2);
        shoppingBasket.addItemToBasket(i2);
        assertEquals(9, shoppingBasket.getBasket().size());
        assertEquals(8.70, discount.bogof(shoppingBasket));
    }

}
