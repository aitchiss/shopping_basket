package com.codeclan.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DiscountManagerTest {

    DiscountManager discountManager;
    Discount bogofDiscount;

    @Before
    public void before(){
        discountManager = new DiscountManager();
        bogofDiscount = new BuyOneGetOneFreeDiscount();
    }

    @Test
    public void testCurrentDiscountsStartsEmpty(){
        assertEquals(0, discountManager.getCurrentDiscounts().size());
    }

    @Test
    public void canAddDiscountToCurrentDiscounts(){
        discountManager.addToCurrentDiscounts(bogofDiscount);
        assertEquals(1, discountManager.getCurrentDiscounts().size());
    }
}