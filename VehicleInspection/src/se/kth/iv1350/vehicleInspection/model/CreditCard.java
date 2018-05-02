package se.kth.iv1350.vehicleInspection.model;

import java.util.Date;
import java.util.Random;

/**
 * Created by henri on 02/05/2017.
 * This class represents a credit Card
 */
public class CreditCard {
    private String holder;
    private String creditCardNumber;
    private Date expireDate;
    private int cvc;
    private int pin;
    private Random rand;

    /**
     * Creates an instance of an credit card
     *
     * @param pin for specified creditCard
     * @param holder for specified creditCard
     * @param expireDate for specified creditCard
     */
    public CreditCard(String holder, int pin, Date expireDate){

        this.creditCardNumber = createCN(); // the creditcard number is randomized for fun
        this.cvc = rand.nextInt((999 - 100) + 1) + 100; // the cvc is randomized for fun
        this.pin = pin;
        this.holder = holder;
        this.expireDate = expireDate;
    }


    /**
     * Method for creating random card number.
     * @return Randomized CreditCardNumber
     */
    private String createCN(){
        StringBuilder cN = new StringBuilder();
        rand = new Random();
        String firstFour = String.valueOf((rand.nextInt((9999 - 1000) + 1) + 1000));
        rand = new Random();
        String secondFour = String.valueOf((rand.nextInt((9999 - 1000) + 1) + 1000));
        rand = new Random();
        String  thirFour = String.valueOf((rand.nextInt((9999 - 1000) + 1) + 1000));
        rand = new Random();
        String  fourFour = String.valueOf((rand.nextInt((9999 - 1000) + 1) + 1000));
        cN.append(firstFour).append(" ");
        cN.append(secondFour).append(" ");
        cN.append(thirFour).append(" ");
        cN.append(fourFour);
        return cN.toString();
    }

    /**
     * Get the cvc number
     * @return the cvc of the card
     */
    public int getCvc(){
        return cvc;
    }

    /**
     *
     * @param cvc
     */
    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public void setCreditCardNumber(String k){this.creditCardNumber = k;}

    /**
     * @return the holder of the card
     */
    public String getHolder(){
        return holder;
    }
    /**
     * @return the credit card number of the card
     */
    public String getCreditCardNumber(){
        return  creditCardNumber;
    }
    /**
     * @return the pin bound to the card
     */
    public int getPin(){
        return pin;
    }

    /**
     * set new pin code
     * @param pin integer representing new pin-code
     */
    public void setPin(int pin) {
        this.pin = pin;
    }

    /**
     * get the expire date of the card
     * @return expire date
     */

    public Date getExpireDate() {
        return expireDate;
    }


}
