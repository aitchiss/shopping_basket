package com.codeclan.shoppingbasket;

/**
 * Created by user on 01/04/2017.
 */

public class OverTwentyPoundsDiscount implements TotalSpendDiscount {

    private String description = "10% off total over £20";
    private double percentageToDiscount = 10.0;

    public String getDescription(){
        return this.description;
    }

    public int calculateDeductions(int totalSpend){
        if (totalSpend > 2000){
            double discount = (this.percentageToDiscount/100) * totalSpend;
            int totalDiscount = (int) Math.round(discount);
            return totalDiscount;
        } else {
            return 0;
        }

    }
}
