package se.kth.iv1350.vehicleInspection.controller;

import se.kth.iv1350.vehicleInspection.integration.*;
import se.kth.iv1350.vehicleInspection.model.*;

import java.util.ArrayList;

/**
 * Created by henri on 02/05/2017.
 *
 * Represents the controller which acts as the mediator between the view and the model
 */
public class Controller {
    private Garage garage;
    private Printer printer;
    private Inspection inspection;
    private InspectionRegistry inspectionRegistry;
    private ExternalAuthorizationCenter externalAuthorizationCenter;
    private CashRegister cashRegister;

    /**
     * Controller constructor, creates an instance of the controller, and initializes the
     * objects that will be controlled.
     *
     * @param g garage
     * @param p printer
     * @param c cash register
     * @param i inspectation registry
     * @param e card payment authorization
     */
    public Controller(Garage g, Printer p, CashRegister c, InspectionRegistry i, ExternalAuthorizationCenter e){
        this.garage = g;
        this.printer = p;
        this.cashRegister = c;
        this.inspectionRegistry = i;
        this.externalAuthorizationCenter = e;

    }

    /**
     * Method for closing the garage
     * @return returns a printout of the garage status.
     */
    public String closeGarageDoor(){
        garage.closeDoor();
        return printer.printGarageDoor(garage.isGarageDoorClosed());
    }
    /**
     * Method for opening the garage
     * @return returns a printout of the garage status.
     */
    public String openGarageDoor(){
        garage.openDoor();
        return printer.printGarageDoor(garage.isGarageDoorClosed());
    }

    /**
     * Sends signal to next in line
     * @return returs string of either busy or next customer may enter.
     */
    public String next(){
        if(!garage.isGarageDoorClosed()) {
            return printer.nextCustomer();
        }else{
            return printer.garageBusy();
        }
    }

    /**
     * Method: Creates a new inspection for the vehicle
     * @param v vehicle that needs inspection
     * @return A message for either busy or that the inspection was a success.
     */
    public String startInspection(Vehicle v){
        if (garage.isGarageDoorClosed()) {
            inspection = new Inspection(v);
            return printer.inspectionDone();
        }else
            return printer.garageBusy();
    }

    /**
     * Method for saving the inspection in the database
     * @return a string that contains a message that the inspection was saved.
     */
    public String saveInspection(){
        inspectionRegistry.addToVehicleInspectionDB(inspection);
        return printer.inspectionSaved(inspection);
    }

    /**
     * Method for getting the list of items from the inspection. The inspection is retrieved from the database.
     * @param reg registration number of the vehicle we want to have our list for.
     * @return A message of the items that need inspection
     * @throws IllegalLicencePlateException
     */
    public String getInspectionList(String reg) throws IllegalLicencePlateException {
        ArrayList<Items> list = inspectionRegistry.getVehicleInspection(reg).getItemsToInspect().getItemsNeeded();
        return printer.printInspectionResults(list);
    }

    /**
     * A method for getting the total cost of the inspection. Inspection retrieved from database
     * @param reg Registration number of the vehicle we want the information on.
     * @return a message of items and its cost.
     * @throws IllegalLicencePlateException
     */
    public String showTotalCost(String reg) throws IllegalLicencePlateException {
        Inspection ins =  inspectionRegistry.getVehicleInspection(reg);
        return printer.totalCostOfRepair(ins);
    }

    /**
     * Check if the inspection passed
     * @param reg which vehicle do we want to check
     * @return true or false (true if below two items need repairing, which means it passed the inspection)
     * @throws IllegalLicencePlateException
     */
    public boolean passOrFail(String reg) throws IllegalLicencePlateException {
        Inspection ins = inspectionRegistry.getVehicleInspection(reg);
        return ins.passedOrFailed();
    }

    /**
     * tells the database to show the results of the inspections done during the run.
     */
    public void getFinalResults(){
        inspectionRegistry.showFinalResults();
    }

    /**
     * Method for cash payment.
     * @param payment the amount paid
     * @return a String containing the receipt
     */

    public String payByCash(double payment)
    {
        return cashRegister.payment(payment,inspection);
    }

    /**
     * Method for credit card payment
     * @param c the card
     * @return a String of a receipt or a message that it failed.
     */

    public String payByCard(CreditCard c) {
        if (externalAuthorizationCenter.externalAuthor(c, inspection.getItemsToInspect())){
            return printer.printCreditCardPayment(inspection.getItemsToInspect(), c, inspection.calculateTotalCost());
        }else
            return "Failed to pay by Card";
    }

    /**
     * Change inspections
     * @param i Inspection we want to control
     */
    public void setInspection(Inspection i){
        this.inspection = i;
    }

    /**
     * Method for creating a new vehicle
     * @param o Owner of the vehicle
     * @param r Registration plate for the vehicle
     * @return v, a new vehicle.
     */
    public Vehicle newVehicle(String o, String r){
        Vehicle v = new Vehicle(o,r);
        return v;
    }

    /**
     * Change the status of the inspection, did the inspection pass or fail?
     */
    public void setPassOrFail(){
        if (inspection.getItemsToInspect().getItemsNeeded().size()< 2){
            inspection.setPass();
        }
    }
}
