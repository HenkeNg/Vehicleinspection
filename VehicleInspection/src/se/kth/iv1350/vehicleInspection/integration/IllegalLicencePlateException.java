package se.kth.iv1350.vehicleInspection.integration;

/**
 * Created by henri on 19/05/2017.
 *
 * Exception being thrown if the inspectionRegistry does not contain the registration number
 */
public class IllegalLicencePlateException extends Exception {

    /**
     *
     * @param regNmbr the registration number for the vehicle
     */
    public IllegalLicencePlateException(String regNmbr){
        super("Unable to find an inspection for the licence plate: "+ regNmbr);
    }
}
