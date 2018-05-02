package se.kth.iv1350.vehicleInspection.model;

import se.kth.iv1350.vehicleInspection.integration.IllegalLicencePlateException;

import java.util.HashMap;

/**
 * Created by henri on 03/05/2017.
 *
 * The database of the company. It contains a map of all the vehicles that have been inspected
 */
public class InspectionRegistry {
    private HashMap<String,Inspection> vehicleInspectionDB;
    private InspectionInterface inspectionInterface;


    public InspectionRegistry(InspectionInterface iO){
        vehicleInspectionDB = new HashMap<>();
        this.inspectionInterface = iO;

    }
    public Inspection getVehicleInspection(String nmb) throws IllegalLicencePlateException {
        if(vehicleInspectionDB.get(nmb) == null)
        {
            throw new IllegalLicencePlateException(nmb);
        }
        return vehicleInspectionDB.get(nmb);
    }

    public void addToVehicleInspectionDB(Inspection v) {

        vehicleInspectionDB.put(v.getRegNmb(),v);
        if(v.passedOrFailed()){
            inspectionInterface.passedTheInspection(v);
        }else{
            inspectionInterface.failedTheInspection(v);
        }
    }

    public void showFinalResults(){
        inspectionInterface.failedInspections();
        inspectionInterface.passeInspections();
    }

}
