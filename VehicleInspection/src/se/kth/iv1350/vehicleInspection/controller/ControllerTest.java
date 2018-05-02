package se.kth.iv1350.vehicleInspection.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.vehicleInspection.integration.ExternalAuthorizationCenter;
import se.kth.iv1350.vehicleInspection.integration.Garage;
import se.kth.iv1350.vehicleInspection.integration.IllegalLicencePlateException;
import se.kth.iv1350.vehicleInspection.integration.Printer;
import se.kth.iv1350.vehicleInspection.model.*;
import se.kth.iv1350.vehicleInspection.view.InspectionStatsView;

import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.*;

public class ControllerTest {

    private Inspection inspection;
    private Vehicle vehicle;
    private CreditCard creditCard;
    private Controller controller;

    @Before
    public void setUp() throws Exception {
        Garage garage = new Garage();
        Printer printer = new Printer();
        InspectionRegistry inspectionRegistry = new InspectionRegistry(new InspectionStatsView());
        ExternalAuthorizationCenter externalAuthorizationCenter = new ExternalAuthorizationCenter();
        CashRegister cashRegister = new CashRegister();
        this.vehicle = new Vehicle("Henrik", "APA:123");
        this.creditCard = new CreditCard("Henrik", 1111, new Date());
        this.inspection = new Inspection(vehicle);
        inspectionRegistry.addToVehicleInspectionDB(inspection);
        this.controller = new Controller(garage,printer,cashRegister,inspectionRegistry,externalAuthorizationCenter);
        controller.setInspection(inspection);

    }

    @After
    public void afterTest() {
        inspection = null;
        vehicle = null;
        creditCard = null;
        controller = null;
    }


    @Test
    public void closeGarageDoor() {
        controller.closeGarageDoor();
        assertTrue(controller.closeGarageDoor().equalsIgnoreCase("The garage door is closing"));
    }

    @Test
    public void openGarageDoor() {
        assertTrue(controller.openGarageDoor().equalsIgnoreCase("The garage door is opening"));
    }

    @Test
    public void next() {

        assertTrue(controller.next().equalsIgnoreCase("A new number is being shown on the display\n A new customer may enter"));
    }

    @Test
    public void startInspection() {
        controller.openGarageDoor();
        assertTrue(controller.startInspection(vehicle).equalsIgnoreCase("The inspection is finished!"));
    }

    @Test
    public void saveInspection() {
        String s = "Inspection of vehicle with Reg: "+inspection.getRegNmb() +" saved in database";
        assertTrue(controller.saveInspection().equalsIgnoreCase(s));
    }

    @Test
    public void getInspectionList() throws IllegalLicencePlateException, IOException {
        assertNotNull(controller.getInspectionList("APA:123"));
        assertNull(controller.getInspectionList("NOT THERE"));
    }

    @Test
    public void showTotalCost() throws IllegalLicencePlateException {
        assertNotNull(controller.showTotalCost("APA:123"));

    }

    @Test
    public void passOrFail() throws IllegalLicencePlateException, IOException {
        controller.passOrFail("APA:123");
    }

    @Test
    public void getFinalResults() {

        controller.getFinalResults();
    }

    @Test
    public void payByCash() {
        double payment = 10000;
        assertNotNull(controller.payByCash(payment));
    }

    @Test
    public void payByCard() {
        assertNotEquals("Failed to pay by Card",controller.payByCard(creditCard));
    }

    @Test
    public void newVehicle() {
        Vehicle v = controller.newVehicle("Henrik","APA:123");
        assertEquals("Henrik",v.getOwner());
    }

}