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
    Discount loyaltyCardDiscount;
    Discount overTwentyPoundsDiscount;

    @Before
    public void before(){
        discountManager = new DiscountManager();
        bogofDiscount = new BuyOneGetOneFreeDiscount();
        loyaltyCardDiscount = new LoyaltyCardDiscount();
        overTwentyPoundsDiscount = new OverTwentyPoundsDiscount();
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

    @Test
    public void canAddCustomerDiscountToCurrentDiscounts(){
        discountManager.addToCurrentDiscounts(loyaltyCardDiscount);
        assertEquals(1, discountManager.getCurrentDiscounts().size());
    }

    @Test
    public void canAddTotalSpendDiscountToCurrentDiscounts(){
        discountManager.addToCurrentDiscounts(overTwentyPoundsDiscount);
        assertEquals(1, discountManager.getCurrentDiscounts().size());
    }

    @Test
    public void canRemoveFromCurrentDiscounts(){
        discountManager.addToCurrentDiscounts(overTwentyPoundsDiscount);
        discountManager.removeFromCurrentDiscounts(overTwentyPoundsDiscount);
        assertEquals(0, discountManager.getCurrentDiscounts().size());
    }
}