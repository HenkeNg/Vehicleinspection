package se.kth.iv1350.vehicleInspection.integration;


import se.kth.iv1350.vehicleInspection.model.Vehicle;

public class ItemCostList {

    public double whatsTheCost(Vehicle.ThingsToRepair k){
        switch (k){
            case Oil:
                return 200.;

            case Door:
                return 1500.;

            case Breaks:
                return 1000.;

            case Signal:
                return 350.;

            case Wheels:
                return 350.;

            case Windows:
                return 2000.;

            case Painting:
                return 550.;

            case Dashboard:
                return 850.;

            case HeadLights:
                return 300.;

            case ExhaustSystem:
                return 4000.;
        }
        return 0.;
    }
}
