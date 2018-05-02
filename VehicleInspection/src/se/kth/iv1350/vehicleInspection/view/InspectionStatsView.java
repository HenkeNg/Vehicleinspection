package se.kth.iv1350.vehicleInspection.view;

import se.kth.iv1350.vehicleInspection.model.Inspection;
import se.kth.iv1350.vehicleInspection.model.InspectionInterface;

/**
 * Created by henri on 19/05/2017.
 */
public class InspectionStatsView implements InspectionInterface {
    private int inspectionsPassed;
    private int inspectionsFailed;

    public InspectionStatsView() {
        this.inspectionsPassed = 0;
        this.inspectionsFailed = 0;
    }

    /**
     * Prints and updates the stats for failed inspections
     * @param v the vehicle that failed the inspection.
     */
    @Override
    public void failedTheInspection(Inspection v) {

        System.out.println("### An inspection for: "+ v.getOwner() + " "+ v.getRegNmb() +" has failed ####");
        inspectionsFailed++;
        System.out.println("The new number of failed inspections are: "+ inspectionsFailed);
        System.out.println("#####################################");
    }

    /**
     * Shows the number of failed inspections
     */
    @Override
    public void failedInspections() {
        System.out.println("### Displaying the number of failed inspections ####");
        System.out.println("The number of failed inspections are: "+ inspectionsFailed);
        System.out.println("#####################################");
    }

    /**
     * Prints and updates the stats for passed inspections
     * @param v the vehicle that passed the inspection.
     */
    @Override
    public void passedTheInspection(Inspection v) {
        System.out.println("### An inspection for: "+ v.getOwner() + " "+ v.getRegNmb() +" was passed ####");
        inspectionsPassed++;
        System.out.println("The new number of passed inspections are: "+ inspectionsPassed);
        System.out.println("#####################################");
    }

    /**
     * Shows the number of passed inspections
     */
    @Override
    public void passeInspections() {
        System.out.println("### Displaying the number of passed inspections ####");
        System.out.println("The number of passed inspections are: "+ inspectionsPassed);
        System.out.println("#####################################");
    }
}
