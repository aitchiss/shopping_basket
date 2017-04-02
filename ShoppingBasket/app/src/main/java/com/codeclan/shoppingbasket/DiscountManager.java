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

    public void addToCurrentDiscounts(Discount discount){
        currentDiscounts.add(discount);
    }

    public void removeFromCurrentDiscounts(Discount discount){
        currentDiscounts.remove(discount);
    }

    public void changeDiscountPriority(Discount discount, int index){
        currentDiscounts.remove(discount);
        currentDiscounts.add(index, discount);
    }

    public int returnTotalAfterDeductions(Customer customer, ArrayList<Item> items){
        int totalCost = getInitialItemTotal(items);
        for (Discount discount : currentDiscounts){
            if (discount instanceof ItemDiscount){
                int deductions = ((ItemDiscount) discount).calculateDeductions(items);
                totalCost -= deductions;
            } else if (discount instanceof CustomerDiscount){
                int deductions = ((CustomerDiscount) discount).calculateDeductions(customer, totalCost);
                totalCost -= deductions;
            } else if (discount instanceof TotalSpendDiscount){
                int deductions = ((TotalSpendDiscount) discount).calculateDeductions(totalCost);
                totalCost -= deductions;
            }
        }
        return totalCost;
    }

    public int getInitialItemTotal(ArrayList<Item> items){
        int total = 0;
        for (Item item: items){
            total += item.getPrice();
        }
        return total;
    }

    public int getTotalSavings(Customer customer, ArrayList<Item> items){
        return getInitialItemTotal(items) - returnTotalAfterDeductions(customer, items);
    }
}
