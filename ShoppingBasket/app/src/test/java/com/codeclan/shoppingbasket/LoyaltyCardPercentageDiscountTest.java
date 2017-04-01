package com.codeclan.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoyaltyCardPercentageDiscountTest {

    LoyaltyCardPercentageDiscount loyaltyCardPercentageDiscount;

    @Before
    public void before(){
        loyaltyCardPercentageDiscount = new LoyaltyCardPercentageDiscount("2% off final total for loyalty card holders", 2);
    }

    @Test
    public void testDiscountHasDescription(){
        assertEquals("2% off final total for loyalty card holders", loyaltyCardPercentageDiscount.getDescription());
    }
}