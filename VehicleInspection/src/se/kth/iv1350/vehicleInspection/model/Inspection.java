package se.kth.iv1350.vehicleInspection.model;

import se.kth.iv1350.vehicleInspection.integration.ItemCostList;
import se.kth.iv1350.vehicleInspection.integration.ItemInspectionList;
import se.kth.iv1350.vehicleInspection.integration.Items;

import java.util.Random;

/**
 * Created by henri on 02/05/2017.
 *
 * Represents an inspection for a specific vehicle
 *  information about the vehicle
 *
 */

public class Inspection {
    private String owner;
    private String regNmb;
    private ItemInspectionList itemsToInspect;
    private boolean passOrFail;

    /**

     *The Constructor of Inspection, an inspection checks for bad parts
     * Initializes the variables used in this class.
     *
     * @param vehicle receives the vehicle object to gather information
     */
    public Inspection(Vehicle vehicle){
        passOrFail = false;
        regNmb = vehicle.getRegistrationNumber();
        owner = vehicle.getOwner();
        // The random repair list, creates a random list of items
        // that needs repairing
        randomRepairList();
    }


    /**
     * A method for finding out what items that needs repair (may produce duplicates)
     */
    private void randomRepairList(){
        ItemCostList costList = new ItemCostList();
        itemsToInspect = new ItemInspectionList();
        Random rand = new Random();
        int num = rand.nextInt(6);
        if (num > 0) {
            for (int i = 0; i < num; i++) {
                int pick = new Random().nextInt(Vehicle.ThingsToRepair.values().length);
                String it = Vehicle.ThingsToRepair.values()[pick].toString();
                Items items = new Items(it, costList.whatsTheCost(Vehicle.ThingsToRepair.values()[pick]));
                itemsToInspect.addToList(items);
            }
        }
    }

    /**
     * Returns the List of items we need to inspect
     * @return itemToInspect, an object that contains the array of items
     */
    public ItemInspectionList getItemsToInspect() {
        return itemsToInspect;
    }

    /**
     * Who's the owner?
     * @return owner of the vehicle for the inspection
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Get the registration number
     * @return registration number
     */
    public String getRegNmb() {
        return regNmb;
    }

    /**
     * Get the total cost of the inspection
     * @return cost which includes inspection fee 500. kr
     */
    public double calculateTotalCost(){
        return itemsToInspect.getTotalCost()+ 500.;
    }

    public boolean passedOrFailed(){
        return passOrFail;
    }

    /**
     * When the inspection has passed, set it to true.
     */
    public void setPass(){
        passOrFail = true;
    }
}
