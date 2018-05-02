package se.kth.iv1350.vehicleInspection.integration;

/**
 * Created by henri on 02/05/2017.
 *
 * Represents the garage where inspections will be held.
 */
public class Garage {

    private boolean garageDoorClosed;

    /**
     * Class constructor, sets garageDoor variable to default mode (false).
     */
    public Garage(){
        garageDoorClosed = false;
    }

    /**
     * Closes the garage door and changes the door status to true(closed)
     *
     */
    public void closeDoor(){
        garageDoorClosed = true;
    }

    /**
     * Opens the door and changes the door status to false(open)
     *
     */
    public void openDoor(){
        garageDoorClosed = false;
    }

    /**
     * Shows the current status of the garage door
     *
     * @return garage door status
     */
    public boolean isGarageDoorClosed(){
        return garageDoorClosed;
    }

}
