package com.codeclan.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BuyOneGetOneFreeDiscountTest {

    BuyOneGetOneFreeDiscount bogofDiscount;
    Item bread;
    Item bread2;
    Item bread3;

    @Before
    public void before(){
        bogofDiscount = new BuyOneGetOneFreeDiscount();
        bread = new Item(1234, "Hovis bread", 120);

        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.addItem(bread);
        shoppingBasket.addItem(bread);
        shoppingBasket.addItem(bread);
    }

    @Test
    public void testDiscountHasDescription(){
        assertEquals("Buy one, get one free", bogofDiscount.getDescription());
    }


}