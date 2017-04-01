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
    Customer customer;

    @Before
    public void before(){
        overTwentyPoundsDiscount = new OverTwentyPoundsDiscount();
        shoppingBasket = new ShoppingBasket();
//        Item bread = new Item(1234, "hovis bread", 120);
//        Item lobster = new Item(5632, "lobster dinner for two", 2550);
//        shoppingBasket.addItem(bread);
//        shoppingBasket.addItem(lobster);

        customer = new Customer("Suzanne", shoppingBasket);

    }

    @Test
    public void testDiscountHasDescription(){
        assertEquals("10% off total over £20", overTwentyPoundsDiscount.getDescription());
    }

    @Test
    public void testDeductsTenPercentIfTotalOverTwenty(){
        assertEquals(267, overTwentyPoundsDiscount.calculateDiscounts(customer, 2670));
    }

    @Test
    public void testDiscountDoesntApplyUnderTwenty(){
        assertEquals(0, overTwentyPoundsDiscount.calculateDiscounts(customer, 1000));
    }
}