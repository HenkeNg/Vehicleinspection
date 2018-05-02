package se.kth.iv1350.vehicleInspection.integration;

import java.util.ArrayList;

/**
 * Created by henri on 05/05/2017.
 * A list of items needed for the inspection
 */
public class ItemInspectionList {
    private ArrayList<Items> itemsNeeded;
    private double totalCost;

    /**
     * Constructor, creates instances of variables for this class
     */
    public ItemInspectionList() {
        itemsNeeded = new ArrayList<>();
        totalCost = 0;
    }

    /**
     * Add an "Items" to the itemsNeeded
     *
     * @param addThis item that should be added to the list
     */
    public void addToList(Items addThis) {
        itemsNeeded.add(addThis);
        totalCost =+ addThis.getPrice();
    }

    /**
     * Get the list of items in the itemsNeeded.
     *
     * @return the list of items
     */
    public ArrayList<Items> getItemsNeeded() {
        return itemsNeeded;
    }

    /**
     * Get the total cost of the itemsNeeded.
     *
     * @return the total cast
     */
    public double getTotalCost() {
        return totalCost;
    }


    /*

     CODE NOT USED IN THIS PROJECT

    /**
     * Set status of an item
     * @param b status
     * @param item which item should have its status changed
     *
    public void setItemStatus(boolean b, String item) {
        ArrayList<Items> temp = new ArrayList<>();
        for (Items i : itemsNeeded) {
            if (i.getItemName().equals(item)) {
                i.setStatus(b);
                temp.add(i);
            }
            itemsNeeded = temp;
        }
    }

    /**
     * Method for checking status of an item
     * @param item name of the item we want to check
     * @return status or default (false) if item was not found
     *
    public boolean getItemStatus(String item){
        for (Items i: itemsNeeded) {
            if (i.getItemName().equals(item)){
                return i.isStatus();
            }
        }
        return false;
    }
    */
}