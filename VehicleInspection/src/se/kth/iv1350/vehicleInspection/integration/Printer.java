package se.kth.iv1350.vehicleInspection.integration;

import se.kth.iv1350.vehicleInspection.model.CreditCard;
import se.kth.iv1350.vehicleInspection.model.Inspection;

import java.util.ArrayList;

/**
 * Created by henri on 02/05/2017.
 *
 * Represents printers for when a printout is requested
 */
public class Printer {
    /**
     * Prints itemsNeeded for a cash payment
     * @param payment amount paid by the customer
     * @param inspectionCost the cost of the inspection
     * @return String of the receipt
     */
    public String printCashReceipt(double payment,double total,ItemInspectionList inspectionCost) {

        StringBuilder r = new StringBuilder();
        ArrayList<Items> rec = inspectionCost.getItemsNeeded();
        if(rec.size()>=1){
            for (Items i: rec) {
                r.append(i.getItemName()).append("              - ").append(i.getPrice()).append("\n");
            }
        }
        r.append("Inspection cost              - "+"500.0\n");
        r.append("Total:                      ").append(total);
        r.append("\nPayment:                    ").append(payment);
        r.append("\n---------------------------------\n");
        r.append("Change:                      ").append(payment - total);
        return r.toString();
    }

    /**
     * Printer method to show what items that need repairing
     * @param itemsNeeded is an object that contains a list of items we need to inspect
     * @return string of receipt
     */
    public String printInspectionResults(ArrayList<Items> itemsNeeded){
        StringBuilder builder = new StringBuilder();
        if(itemsNeeded.size()>= 1) {
            for (Items i : itemsNeeded) {
                builder.append(i.getItemName()).append("\n");
            }
        }else{
            builder.append("List is empty");
        }
        return builder.toString();
    }

    /**
     * Printer method for credit card payment
     * @param inspectionCost the cost of the repair
     * @param card  the card which was used to pay
     * @param total the cost of the service
     * @return String of receipt
     */
    public String printCreditCardPayment(ItemInspectionList inspectionCost, CreditCard card,double total){
        StringBuilder r = new StringBuilder();
        ArrayList<Items> rec = inspectionCost.getItemsNeeded();
        if(rec.size()>=1) {
            for (Items i : rec) {
                r.append(i.getItemName()).append("              - ").append(i.getPrice()).append("\n");
            }
            r.append("Inspection              - " + "500.0\n");
        }
        return (r.toString()+"Total cost: "+total+" \nChange: 0"+ "\npaid by: "+card.getHolder()+ " ["+ card.getCreditCardNumber()+"]");
    }

    /**
     * Garage door status printer, open or close door
     * @param d close and open door
     * @return string
     */
    public String printGarageDoor(boolean d){
        //if true close door
        if (d){
            return"The garage door is closing";
        }else
            return "The garage door is opening";
    }

    /**
     * Finished inspection print.
     * @return
     */
    public String inspectionDone(){
        return "The inspection is finished!";
    }

    /**
     * Signal next customer to enter
     * @return
     */
    public String nextCustomer(){
        return "A new number is being shown on the display\n A new customer may enter";
    }

    public String garageBusy(){
        return "The garage is currently busy.";
    }

    public String inspectionSaved(Inspection i){

        return ("Inspection of vehicle with Reg: "+i.getRegNmb() +" saved in database");
    }

    /**
     * Print cost for the service
     * @param inspection an object that contains information about the inspectation
     * @return String
     */
    public String totalCostOfRepair(Inspection inspection){
        StringBuilder r = new StringBuilder();
        ArrayList<Items> rec = inspection.getItemsToInspect().getItemsNeeded();
        if(rec.size()>=1) {
            for (Items i : rec) {
                r.append(i.getItemName()).append("              - ").append(i.getPrice()).append("\n");
            }
            r.append("Inspection cost              - " + "500.0\n");
        }
        r.append("The total cost of the service: ").append(inspection.calculateTotalCost());
        return (r.toString());
    }
}
