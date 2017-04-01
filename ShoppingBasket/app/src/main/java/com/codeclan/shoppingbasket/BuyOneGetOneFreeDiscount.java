package com.codeclan.shoppingbasket;

/**
 * Created by user on 01/04/2017.
 */

public class BuyOneGetOneFreeDiscount implements ItemDiscount {

    private String description = "Buy one, get one free";

    public String getDescription(){
        return this.description;
    }
}
