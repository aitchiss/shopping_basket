package com.codeclan.shoppingbasket;

/**
 * Created by user on 01/04/2017.
 */

public interface CustomerDiscount {

    public int calculateDeductions(Customer customer, int totalSpend);
}
