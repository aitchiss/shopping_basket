package com.codeclan.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ShoppingBasketTest {

    ShoppingBasket shoppingBasket;

    @Before
    public void before(){
        shoppingBasket = new ShoppingBasket();
    }

    @Test
    public void shoppingBasketStartsEmpty(){
        assertEquals(0, shoppingBasket.getItems().size());
    }
}