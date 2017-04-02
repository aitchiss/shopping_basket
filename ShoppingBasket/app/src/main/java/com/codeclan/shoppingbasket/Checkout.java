package com.codeclan.shoppingbasket;

/**
 * Created by user on 02/04/2017.
 */

public class Checkout {

    private Customer customer;
    private DiscountManager discountManager;

    public Checkout(Customer customer, DiscountManager discountManager){
        this.customer = customer;
        this.discountManager = discountManager;
    }

    public Customer getCustomer() {
        return customer;
    }

    public DiscountManager getDiscountManager() {
        return discountManager;
    }

    public int getTotalToPay(){
        return discountManager.returnTotalAfterDeductions(customer, customer.getShoppingBasket().getItems());
    }

    public int getTotalDiscountsApplied(){
        int totalBeforeDiscounts = discountManager.getInitialItemTotal(customer.getShoppingBasket().getItems());
        return totalBeforeDiscounts - getTotalToPay();
    }
}
