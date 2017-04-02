package com.codeclan.shoppingbasket;

/**
 * Created by user on 01/04/2017.
 */

public class Item{

    //productID represents barcode - in reality, name of product/price would be linked to barcode
    //in database or similar. Have included in constructor for simplicity.

    private int productId;
    private String name;
    private int price; //in pence

    public Item(int productId, String name, int price){
        this.productId = productId;
        this.name = name;
        this.price = price;
    }


   public int getProductId(){
       return this.productId;
   }

   public String getName(){
       return this.name;
   }

   public int getPrice(){
       return this.price;
   }
}
