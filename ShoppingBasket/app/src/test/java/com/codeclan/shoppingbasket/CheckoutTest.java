package com.codeclan.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CheckoutTest {

    Customer customer;
    Checkout checkout;

    @Before
    public void before(){
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        customer = new Customer("Suzanne", shoppingBasket);
        checkout = new Checkout(customer);
    }

    @Test
    public void testCheckoutHasCustomer(){
        assertEquals(customer, checkout.getCustomer());
    }
}