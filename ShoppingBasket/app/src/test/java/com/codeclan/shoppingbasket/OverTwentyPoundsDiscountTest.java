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

    @Before
    public void before(){
        overTwentyPoundsDiscount = new OverTwentyPoundsDiscount();

    }

    @Test
    public void testDiscountHasDescription(){
        assertEquals("10% off total over £20", overTwentyPoundsDiscount.getDescription());
    }
}