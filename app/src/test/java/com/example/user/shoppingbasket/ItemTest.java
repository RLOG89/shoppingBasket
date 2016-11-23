package com.example.user.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 22/11/2016.
 */

public class ItemTest {

    Item i;

    @Before
    public void before() {
         i = new Item("chicken", 4.50);
    }

    @Test
    public void itemHasName() {
        assertEquals("chicken", i.getName());
    }

    @Test
    public void itemHasPrice() {
        assertEquals(4.50, i.getPrice());
    }
}
