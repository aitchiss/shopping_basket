package com.codeclan.shoppingbasket;

/**
 * Created by user on 01/04/2017.
 */

public class Customer {

    private String name;
    private ShoppingBasket shoppingBasket;
    private int loyaltyCardNumber;

    public Customer(String name, ShoppingBasket shoppingBasket){
        this.name = name;
        this.shoppingBasket = shoppingBasket;
        this.loyaltyCardNumber = -1;
    }

    public String getName(){
        return this.name;
    }

    public ShoppingBasket getShoppingBasket(){
        return this.shoppingBasket;
    }

    public boolean hasLoyaltyCard(){
        if (loyaltyCardNumber != -1){
            return true;
        } else {
            return false;
        }
    }
}
