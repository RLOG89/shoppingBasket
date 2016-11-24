package com.example.user.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * Created by user on 23/11/2016.
 */

public class CustomerTest {

    private Customer customer1;
    private Customer customer2;

    @Before
    public void before() {
        customer1 = new Customer("Bob", true);
        customer2 = new Customer("John", false);
    }

    @Test
    public void canGetName() {
        assertEquals("Bob", customer1.getName());
    }

    @Test
    public void checkIfHaveLoyaltyCard() {
        assertEquals(true, customer1.hasLoyaltyCard());
        assertEquals(false, customer2.hasLoyaltyCard());
    }
}
