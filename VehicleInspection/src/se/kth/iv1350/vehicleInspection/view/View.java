package se.kth.iv1350.vehicleInspection.view;

import se.kth.iv1350.vehicleInspection.controller.Controller;
import se.kth.iv1350.vehicleInspection.integration.IllegalLicencePlateException;
import se.kth.iv1350.vehicleInspection.log.Logger;
import se.kth.iv1350.vehicleInspection.model.CreditCard;
import se.kth.iv1350.vehicleInspection.model.Vehicle;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by henri on 03/05/2017.
 *
 *
 * The View will simulate an inspection from when a vehicle enters the garage,
 * to when it pass/fail the inspection and lastly a payment method for the user
 *
 * To run the simulation Run Main class in the startup container
 */

public class View {
    private Controller controller;
    private  Vehicle vehicle;
    private Logger log;


    public View (Controller c){
        this.controller = c;
        this.log = new Logger();
    }

    /**
     * Represents the UI
     *
     * @throws InterruptedException if the thread is being interrupted while sleeping, the sleep is there
     * to slow down the process
     */
    public void start() throws InterruptedException, IOException {

        while (true){
            Scanner reader = new Scanner(System.in);
            System.out.println("Run the simulation by typing run or type quit to end the program");

            String command = reader.next();
            if(command.equalsIgnoreCase("run")) {
                System.out.println("A new inspection is about to start!\n");
                System.out.println(controller.openGarageDoor()+"\n");
                System.out.println(controller.next()+"\n");
                Thread.sleep(300);

                vehicle = createNewVehicle();
                System.out.println("\nSetting up a card holder! (for later)");
                CreditCard creditCard = createCard(vehicle);
                System.out.println(controller.closeGarageDoor());
                System.out.println("The owner and registration number has been confirmed" +
                        "\nAn inspection will now start\n");
                Thread.sleep(300);

                System.out.println(controller.startInspection(vehicle));
                controller.setPassOrFail();

                Thread.sleep(300);
                System.out.println("The inspectation will be stored in the database\n");
                System.out.println(controller.saveInspection());
                Thread.sleep(300);

                try {
                    if (controller.passOrFail(vehicle.getRegistrationNumber())) {
                        System.out.println("The vehicle passed the inspection\n");
                    } else {
                        System.out.println("The vehicle failed the inspection\n");
                    }
                } catch (IllegalLicencePlateException e) {
                    log.log(e);
                    System.out.println("Could not find inspection!");
                }
                Thread.sleep(300);

                System.out.println("the items that need repair or replacement are: ");
                try {
                    System.out.println(controller.getInspectionList(vehicle.getRegistrationNumber()));
                } catch (IllegalLicencePlateException e) {
                    log.log(e);
                    System.out.println("Could not find inspection!");
                }
                System.out.println("the total costs are: ");
                try {
                    System.out.println(controller.showTotalCost(vehicle.getRegistrationNumber()));
                } catch (IllegalLicencePlateException e) {
                    log.log(e);
                    System.out.println("Could not find inspection!");
                }
                payment(creditCard);

                controller.getFinalResults();

                System.out.println("\n Simulation done! \n");
            }else{
                break;
            }
        }
    }

    /**
     * Method for creating/receiving a new car to be inspected
     * @return Vehicle
     */
    private Vehicle createNewVehicle(){
        Scanner reader = new Scanner(System.in);
        System.out.println("A vehicle has entered the garage \nPlease confirm owner:");
        String owner = reader.next();
        System.out.println("Please confirm Registration plate: ");
        String reg = reader.next();

        return  controller.newVehicle(owner,reg);
    }

    /**
     * Method to create a new card for payment.
     *
     * @param v The vehicle, to find owner name
     * @return CreditCard
     */
    private CreditCard createCard(Vehicle v){
        Scanner reader = new Scanner(System.in);
        System.out.println("Card holder = "+ v.getOwner()+
                "\n");
        System.out.println("please select a 4 digit PIN: ");
        int pin = reader.nextInt();
        System.out.println("Credit card confirmed!\n");

        return new CreditCard(v.getOwner(),pin,new Date());
    }

    /**
     * Method called when a payment is being made in the UI
     *
     * @param c The Credit card that will be used to pay for the inspection.
     */
    private void payment(CreditCard c){
        Scanner reader = new Scanner(System.in);
        System.out.println("\nPlease enter payment method [cash] or [credit]:\n");
        String cOc = reader.next();
        if(cOc.equals("cash")){
            System.out.println("Payment by [CASH] was selected: \nplease type in the amount");
            double payment = reader.nextDouble();
            System.out.println("The receipt: ");
            System.out.println(controller.payByCash(payment));
        }else{
            System.out.println("Payment by [CREDIT] was selected");
            System.out.println(controller.payByCard(c));
        }
    }
}
