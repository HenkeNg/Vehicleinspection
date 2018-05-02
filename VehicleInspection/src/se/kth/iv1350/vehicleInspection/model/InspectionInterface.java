package se.kth.iv1350.vehicleInspection.model;

/**
 * Created by henri on 19/05/2017.
 * The interface of the inspectionView
 */
public interface InspectionInterface {


    /**
     * Reports UPDATED stats on a failed inspection
     * @param v the vehicle that failed the inspection.
     */
    void failedTheInspection(Inspection v);

    /**
     * Reports the current stats of failed inspections.
     */
    void failedInspections();

    /**
     * Reports UPDATED stats on a passed inspection
     * @param v the vehicle that passed the inspection.
     */
    void passedTheInspection(Inspection v);

    /**
     * Reports the current stats of passed inspections.
     */
    void passeInspections();
}
