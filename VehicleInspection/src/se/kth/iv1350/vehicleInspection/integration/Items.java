package se.kth.iv1350.vehicleInspection.integration;

/**
 * Created by henri on 13/04/2018.
 *
 * Represents an item and its cost.
 */
public class Items {
    private String itemName;
    private double price;
    private boolean status;

    public Items(String i, double p){
        this.itemName = i;
        this.price = p;
        this.status = false;
    }
    /**
     * Get the item name
     * @return the name of the item
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Set the name of the item
     * @param itemName the name of the item
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Get the item price
     * @return the cost of repair
     */
    public double getPrice() {
        return price;
    }

    /**
     * Check status of the item we need to repair
     * @return  true = the item was replaced/repaired
     *          false = the item has not been replaced/repaired yet
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Set the status of the item that needs repairing
     * @param status the current status of the item
     *               true = item is replaced/repaired
     *               false = item is not replaced/repaired
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Set the price of the item
     * @param price new cost of repair
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
