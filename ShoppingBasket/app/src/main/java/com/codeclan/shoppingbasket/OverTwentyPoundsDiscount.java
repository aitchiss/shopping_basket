package com.codeclan.shoppingbasket;

/**
 * Created by user on 01/04/2017.
 */

public class OverTwentyPoundsDiscount implements TotalSpendDiscount {

    private String description = "10% off total over £20";

    public String getDescription(){
        return this.description;
    }
}
