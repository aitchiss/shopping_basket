package com.codeclan.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoyaltyCardDiscountTest {

    LoyaltyCardDiscount loyaltyCardDiscount;
    Customer customer;

    @Before
    public void before(){
        loyaltyCardDiscount = new LoyaltyCardDiscount();
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.addItem(new Item(1234, "bread", 120));
        shoppingBasket.addItem(new Item(1234, "bread", 120));
        customer = new Customer("Suzanne", shoppingBasket);
    }

    @Test
    public void testDiscountHasDescription(){
        assertEquals("2% off final total for loyalty card holders", loyaltyCardDiscount.getDescription());
    }

    @Test
    public void testDeductionForNoLoyaltyCardIsZero(){
        assertEquals(0, loyaltyCardDiscount.calculateDeductions(customer, 240));
    }

    @Test
    public void testDeductionReturnedForCardHolders(){
        customer.addLoyaltyCard(123456788);
        assertEquals(5, loyaltyCardDiscount.calculateDeductions(customer, 240));
    }
}