package com.codeclan.shoppingbasket;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by user on 01/04/2017.
 */

public class ShoppingBasket {

    private ArrayList<Item> itemsInBasket;

    public ShoppingBasket(){
        this.itemsInBasket = new ArrayList<Item>();
    }

    public ArrayList<Item> getItems(){
        return this.itemsInBasket;
    }
}
