package com.codeclan.shoppingbasket;

/**
 * Created by user on 01/04/2017.
 */

public interface TotalSpendDiscount extends Discount {

    public int calculateDeductions(int totalSpend);
}
