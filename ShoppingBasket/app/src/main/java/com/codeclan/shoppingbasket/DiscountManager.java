package com.codeclan.shoppingbasket;

import java.util.ArrayList;

/**
 * Created by user on 02/04/2017.
 */

public class DiscountManager {

    private ArrayList<Discount> currentDiscounts;

    public DiscountManager(){
        this.currentDiscounts = new ArrayList<Discount>();
    }

    public ArrayList<Discount> getCurrentDiscounts() {
        return currentDiscounts;
    }
}
