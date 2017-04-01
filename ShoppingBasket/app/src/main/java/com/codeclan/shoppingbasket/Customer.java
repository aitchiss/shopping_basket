package com.codeclan.shoppingbasket;

/**
 * Created by user on 01/04/2017.
 */

public class Customer {

    private String name;
    private ShoppingBasket shoppingBasket;

    public Customer(String name, ShoppingBasket shoppingBasket){
        this.name = name;
        this.shoppingBasket = shoppingBasket;
    }

    public String getName(){
        return this.name;
    }

    public ShoppingBasket getShoppingBasket(){
        return this.shoppingBasket;
    }
}
