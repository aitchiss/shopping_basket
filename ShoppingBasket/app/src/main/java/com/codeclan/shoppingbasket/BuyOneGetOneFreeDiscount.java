package com.codeclan.shoppingbasket;

import java.util.ArrayList;

/**
 * Created by user on 01/04/2017.
 */

public class BuyOneGetOneFreeDiscount implements ItemDiscount {

    private String description = "Buy one, get one free";
    private ArrayList<Integer> productsInOffer;

    public BuyOneGetOneFreeDiscount(){
        productsInOffer = new ArrayList<Integer>();
    }

    public String getDescription(){
        return this.description;
    }

    public void addToOffer(Item item){
        if (!productsInOffer.contains(item.getProductId())){
            this.productsInOffer.add(item.getProductId());
        }
    }

    public boolean isInOffer(Item item){
        for (Integer productId : productsInOffer){
            if (productId.equals(item.getProductId())){
                return true;
            }
        }
        return false;
    }


}
