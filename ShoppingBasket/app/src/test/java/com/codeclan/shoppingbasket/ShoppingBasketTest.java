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
    Item bread;

    @Before
    public void before(){
        shoppingBasket = new ShoppingBasket();
        bread = new Item(1234, "Hovis Bread", 120);
    }

    @Test
    public void shoppingBasketStartsEmpty(){
        assertEquals(0, shoppingBasket.getItems().size());
    }

    @Test
    public void testCanAddToBasket(){
        shoppingBasket.addItem(bread);
        assertEquals(1, shoppingBasket.getItems().size());
    }
}