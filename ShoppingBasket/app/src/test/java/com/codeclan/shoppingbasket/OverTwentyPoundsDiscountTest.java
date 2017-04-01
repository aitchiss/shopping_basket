package com.codeclan.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class OverTwentyPoundsDiscountTest {

    OverTwentyPoundsDiscount overTwentyPoundsDiscount;
    ShoppingBasket shoppingBasket;

    @Before
    public void before(){
        overTwentyPoundsDiscount = new OverTwentyPoundsDiscount();
        shoppingBasket = new ShoppingBasket();
    }

    @Test
    public void testDiscountHasDescription(){
        assertEquals("10% off total over £20", overTwentyPoundsDiscount.getDescription());
    }

    @Test
    public void testDeductsTenPercentIfTotalOverTwenty(){
        assertEquals(267, overTwentyPoundsDiscount.calculateDeductions(2670));
    }

    @Test
    public void testDiscountDoesntApplyUnderTwenty(){
        assertEquals(0, overTwentyPoundsDiscount.calculateDeductions(1000));
    }
}