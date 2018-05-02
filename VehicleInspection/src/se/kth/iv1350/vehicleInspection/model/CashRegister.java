package se.kth.iv1350.vehicleInspection.model;

import se.kth.iv1350.vehicleInspection.integration.Printer;

/**
 * Created by henri on 03/05/2017.
 */
public class CashRegister {
    /**
     * Cash register receives a payment and gives back change.
     * @param payment The amount of money paid by the customer
     * @param inspection the inspection to find out what items need repairing
     * @return the differatential returned, however if the payment
     * was lower we return 0.0 to simplify the
     */

    public String payment(double payment,Inspection inspection){
        Printer printer = new Printer();
       return printer.printCashReceipt(payment,inspection.calculateTotalCost(),inspection.getItemsToInspect());
    }
}
