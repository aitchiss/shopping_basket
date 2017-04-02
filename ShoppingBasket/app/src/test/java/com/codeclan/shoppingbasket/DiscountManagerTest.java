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
    BuyOneGetOneFreeDiscount bogofDiscount;
    CustomerDiscount loyaltyCardDiscount;
    TotalSpendDiscount overTwentyPoundsDiscount;
    Item bread;

    @Before
    public void before(){
        bread = new Item(1234, "White bread", 99);

        discountManager = new DiscountManager();
        bogofDiscount = new BuyOneGetOneFreeDiscount();
        bogofDiscount.addToOffer(bread);

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

    @Test
    public void canChangePositionOfDiscount(){
        discountManager.addToCurrentDiscounts(bogofDiscount);
        discountManager.addToCurrentDiscounts(overTwentyPoundsDiscount);
        discountManager.addToCurrentDiscounts(loyaltyCardDiscount);
        discountManager.changeDiscountPriority(loyaltyCardDiscount, 0);
        assertEquals(0, discountManager.getCurrentDiscounts().indexOf(loyaltyCardDiscount));
    }

    @Test
    public void testCanCalculateAllDiscountDeductions(){
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        Item milk = new Item(6654, "milk", 100);
        Item fancyWine = new Item(8778, "very nice wine", 2300);
        shoppingBasket.addItem(fancyWine);
        shoppingBasket.addItem(milk);
        shoppingBasket.addItem(milk);
        shoppingBasket.addItem(bread);
        shoppingBasket.addItem(bread);
        shoppingBasket.addItem(bread);

        Customer customer = new Customer("Suzanne", shoppingBasket);
        customer.addLoyaltyCard(123456);

        discountManager.addToCurrentDiscounts(bogofDiscount);
        discountManager.addToCurrentDiscounts(overTwentyPoundsDiscount);
        discountManager.addToCurrentDiscounts(loyaltyCardDiscount);

        int totalCost = discountManager.returnTotalAfterDeductions(customer, shoppingBasket.getItems());
        //total spend is 2797
        // bogof deduction is 99, leaving 2698
        // overtwenty deduction is 270 leaving 2428
        // loyalty deduction is 49
        // total deductions should be 418, final total should be 2379
        assertEquals(2379, totalCost);
    }

    @Test
    public void calculateFinalTotalWorksIfSomeDiscountsNotApplied(){
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        Item milk = new Item(6654, "milk", 100);
        Item fancyWine = new Item(8778, "very nice wine", 2300);
        shoppingBasket.addItem(fancyWine);
        shoppingBasket.addItem(milk);
        shoppingBasket.addItem(milk);
        shoppingBasket.addItem(bread);
        shoppingBasket.addItem(bread);
        shoppingBasket.addItem(bread);

        Customer customer = new Customer("Suzanne", shoppingBasket);

        discountManager.addToCurrentDiscounts(bogofDiscount);
        discountManager.addToCurrentDiscounts(overTwentyPoundsDiscount);
        discountManager.addToCurrentDiscounts(loyaltyCardDiscount);

        int totalCost = discountManager.returnTotalAfterDeductions(customer, shoppingBasket.getItems());
        assertEquals(2428, totalCost);
    }

    @Test
    public void calculateFinalTotalWorksIfNoDiscountsApplied(){
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        Item milk = new Item(6654, "milk", 100);
        shoppingBasket.addItem(milk);
        shoppingBasket.addItem(milk);
        shoppingBasket.addItem(bread);

        Customer customer = new Customer("Suzanne", shoppingBasket);

        discountManager.addToCurrentDiscounts(bogofDiscount);
        discountManager.addToCurrentDiscounts(overTwentyPoundsDiscount);
        discountManager.addToCurrentDiscounts(loyaltyCardDiscount);

        int totalCost = discountManager.returnTotalAfterDeductions(customer, shoppingBasket.getItems());
        assertEquals(299, totalCost);
    }

    @Test
    public void calculateFinalCostWorksIfNoCurrentDiscounts(){
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        Item milk = new Item(6654, "milk", 100);
        shoppingBasket.addItem(milk);
        shoppingBasket.addItem(milk);
        shoppingBasket.addItem(bread);

        Customer customer = new Customer("Suzanne", shoppingBasket);
        int totalCost = discountManager.returnTotalAfterDeductions(customer, shoppingBasket.getItems());
        assertEquals(299, totalCost);
    }
}