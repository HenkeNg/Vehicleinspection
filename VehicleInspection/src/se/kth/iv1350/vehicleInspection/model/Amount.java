package se.kth.iv1350.vehicleInspection.model;

/**
 * Created by henri on 05/05/2017.
 * A class to represent currency. It can be used if you want to switch between currencies
 * and vary the amount.
 * ***********************************************
 * OBS!!!! The class is not used currently.
 * ************************************************
 */
public class Amount {
    String currency;
    double value;

    /**
     * Shows the Amount and in what type of currency
     *
     * @param currency
     * @param value
     */
    public Amount(String currency, double value){
        this.currency = currency;
        this.value = value;
    }

    /**
     * Set the type of the currency
     * @param currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Set the Actual amount of the currency
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Get the type of the currency
     * @return the currency
     */
    public String getCurry(){
        return currency;
    }

    /**
     * Get the Actual amount of the currency
     * @return the "Amount"
     */
    public  double getValue(){
        return value;
    }
}
