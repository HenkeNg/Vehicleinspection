package se.kth.iv1350.vehicleInspection.startup;


import se.kth.iv1350.vehicleInspection.controller.Controller;
import se.kth.iv1350.vehicleInspection.integration.ExternalAuthorizationCenter;
import se.kth.iv1350.vehicleInspection.integration.Garage;
import se.kth.iv1350.vehicleInspection.integration.IllegalLicencePlateException;
import se.kth.iv1350.vehicleInspection.integration.Printer;
import se.kth.iv1350.vehicleInspection.model.CashRegister;
import se.kth.iv1350.vehicleInspection.model.InspectionRegistry;
import se.kth.iv1350.vehicleInspection.view.InspectionStatsView;
import se.kth.iv1350.vehicleInspection.view.View;

import java.io.IOException;

/**
 * Created by henri on 02/05/2017.
 *
 * Starts the whole process.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        Controller c = new Controller(new Garage(),new Printer(),new CashRegister(),
                new InspectionRegistry(new InspectionStatsView()),
                new ExternalAuthorizationCenter());

        View v = new View(c);

        v.start();
    }
}
