package com.codeclan.shoppingbasket;

/**
 * Created by user on 02/04/2017.
 */

public class Checkout {

    private Customer customer;

    public Checkout(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
