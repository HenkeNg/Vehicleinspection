package se.kth.iv1350.vehicleInspection.log;


import se.kth.iv1350.vehicleInspection.integration.IllegalLicencePlateException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by henri on 13/04/2018.
 *
 * Logger logs exceptions that occurred during the run.
 */
public class Logger {


    public void log(IllegalLicencePlateException exception) {
        try {
            FileWriter f = new FileWriter("LOG",true);
            BufferedWriter b = new BufferedWriter(f);
            PrintWriter pw = new PrintWriter(b);
            String str = ("Date: "+ new Date()+ " Exception: " + exception);
            pw.println(str);
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
