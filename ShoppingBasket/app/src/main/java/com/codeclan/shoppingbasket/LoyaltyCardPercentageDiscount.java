package com.codeclan.shoppingbasket;

/**
 * Created by user on 01/04/2017.
 */

public class LoyaltyCardPercentageDiscount implements CustomerDiscount, Discount {

    private String description;
    private int percentageToDiscount;

    public LoyaltyCardPercentageDiscount(String description, int percentageToDiscount){
        this.description = description;
        this.percentageToDiscount = percentageToDiscount;
    }

    public String getDescription(){
        return this.description;
    }

    public int calculateDeductions(Customer customer, int totalSpend){
        if (customer.hasLoyaltyCard() == false){
            return 0;
        } else {
            return (totalSpend/100) * this.percentageToDiscount;
        }
    }
}
