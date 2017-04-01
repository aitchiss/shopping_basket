package com.codeclan.shoppingbasket;

/**
 * Created by user on 01/04/2017.
 */

public class LoyaltyCardDiscount implements CustomerDiscount {

    private String description = "2% off final total for loyalty card holders";
    private double percentageToDiscount = 2.0;


    public String getDescription(){
        return this.description;
    }

    public int calculateDeductions(Customer customer, int totalSpend){
        if (customer.hasLoyaltyCard() == false){
            return 0;
        } else {
            double discount = (this.percentageToDiscount/100.0) * totalSpend;
            int intDiscount = (int) Math.round(discount);
            return intDiscount;
        }
    }
}
