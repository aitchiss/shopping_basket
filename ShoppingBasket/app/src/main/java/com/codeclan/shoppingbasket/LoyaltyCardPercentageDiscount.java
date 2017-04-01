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
}
