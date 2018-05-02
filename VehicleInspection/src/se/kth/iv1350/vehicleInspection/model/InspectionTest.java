package se.kth.iv1350.vehicleInspection.model;

import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.vehicleInspection.integration.ItemInspectionList;
import se.kth.iv1350.vehicleInspection.integration.Items;

import static org.junit.Assert.assertNotEquals;

public class InspectionTest {

    private Inspection inspection;


    @Before
    public void setUp() throws Exception {
        Vehicle v = new Vehicle("Henke", "APA:123");
        inspection = new Inspection(v);
    }

    @Test
    public void calculateCost() throws Exception {
        double k = 500.;
        assertNotEquals(k, inspection.calculateTotalCost(),0);
    }
    @Test
    public void getItemsToInspect() throws Exception {
        assertNotEquals(null, inspection.getItemsToInspect());
        ItemInspectionList k = inspection.getItemsToInspect();
        if(k.getItemsNeeded().size() >= 1){
            for (Items it :k.getItemsNeeded()) {
                System.out.println(it.getItemName());
            }
        }else{
            System.out.println("The list is empty!");
        }

    }

}
