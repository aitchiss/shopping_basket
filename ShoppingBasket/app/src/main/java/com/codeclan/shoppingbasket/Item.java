package com.codeclan.shoppingbasket;

/**
 * Created by user on 01/04/2017.
 */

public class Item{

    //In reality, existing productIDs (barcodes) and their associated names and price would likely
    // be held in a database. Have included name and price in constructor here for simplicity.

    private int productId;
    private String name;

    public Item(int productId, String name){
        this.productId = productId;
        this.name = name;
    }


   public int getProductId(){
       return this.productId;
   }

   public String getName(){
       return this.name;
   }
}
