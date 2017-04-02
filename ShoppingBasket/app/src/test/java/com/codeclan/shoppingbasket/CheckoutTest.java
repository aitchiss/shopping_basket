package com.codeclan.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CheckoutTest {

    Customer customer;
    Checkout checkout;
    DiscountManager discountManager;

    @Before
    public void before(){
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        Item bread = new Item(1234, "bread", 120);
        shoppingBasket.addItem(bread);
        shoppingBasket.addItem(bread);
        shoppingBasket.addItem(bread);
        shoppingBasket.addItem(new Item(7765, "lobster for two", 3500));


        discountManager = new DiscountManager();
        BuyOneGetOneFreeDiscount bogofDiscount = new BuyOneGetOneFreeDiscount();
        bogofDiscount.addToOffer(bread);
        discountManager.addToCurrentDiscounts(bogofDiscount);
        discountManager.addToCurrentDiscounts(new OverTwentyPoundsDiscount());
        discountManager.addToCurrentDiscounts(new LoyaltyCardDiscount());

        customer = new Customer("Suzanne", shoppingBasket);
        customer.addLoyaltyCard(1234567);
        checkout = new Checkout(customer, discountManager);
    }

    @Test
    public void testCheckoutHasCustomer(){
        assertEquals(customer, checkout.getCustomer());
    }

    @Test
    public void testCheckoutHasDiscountManager(){
        assertEquals(discountManager, checkout.getDiscountManager());
    }

    @Test
    public void testCheckoutCanGetTotalCostForCustomer(){
        int expectedTotal = 3299;
        int calculatedTotal = checkout.getTotalToPay();
        assertEquals(expectedTotal, calculatedTotal);

    }
}