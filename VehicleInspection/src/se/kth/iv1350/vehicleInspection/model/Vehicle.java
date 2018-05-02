package se.kth.iv1350.vehicleInspection.model;

/**
 * Created by henri on 02/05/2017.
 *
 * Represents a vehicle
 */
public class Vehicle {
    String owner;
    String registrationNumber;

    /**
     * inspectionStatus represents if a car has had an inspectation or not.
     * It is initially set to false which means it has not been inspected.
     */
    boolean inspectionStatus;

    /**
     * enum list of things that might need repairing
     */
    public enum ThingsToRepair {
        Painting,
        Windows,
        ExhaustSystem,
        Breaks,
        HeadLights,
        Door,
        Signal,
        Dashboard,
        Wheels,
        Oil
    }

    /**
     * Creates an instance of an Vehicle with an owner
     *
     * @param owner is the owner of the vehicle
     * @param registrationNumber is the registration number for the vehicle that is being inspected
     */
    public Vehicle(String owner,String registrationNumber){
        this.owner = owner;
        this.registrationNumber = registrationNumber;
        this.inspectionStatus = false;

    }

    /**
     *
     * @return a string of what to inspect
     */
    public String getOwner(){
        return owner;
    }

    /**
     *
     * @return the stataus
     */
    public boolean getStatus(){return inspectionStatus;}

    /**
     *
     * @return registration number
     */
    public String getRegistrationNumber(){
        return registrationNumber;
    }

    /**
     * Set the status of a vehicle inspection
     * @param inspectionStatus tells if the vehicle has been inspected or not.
     */
    public void setInspectionStatus(boolean inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }




}
