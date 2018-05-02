package se.kth.iv1350.vehicleInspection.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by henri on 14-04-2018.
 */
public class CreditCardTest {

    private CreditCard creditCard;
    @Before
    public void setUp() throws Exception {

        creditCard = new CreditCard("Henke",2424,new Date());
        creditCard.setCvc(450);
        creditCard.setCreditCardNumber("1111 1111 1111 1111");
    }

    @Test
    public void getPin() throws Exception {
        int pin = 2424;
        assertEquals("get pin matches",creditCard.getPin(), pin);
    }

    @Test
    public void getNumber() throws Exception {
        String number = "1111 1111 1111 1111";
        assertEquals("get number matches",creditCard.getCreditCardNumber(), number);

    }

    @Test
    public void getHolder() throws Exception {
        String holder = "Henke";
        assertEquals("get holder matches",creditCard.getHolder(), holder);
    }

    @Test
    public void getExpiryDate() throws Exception {
        Date expiryDate = new Date();
        assertEquals("get expiry date matches",creditCard.getExpireDate(), expiryDate);
    }

    @Test
    public void getCVC() throws Exception {
        int CVC = 450;
        assertEquals("get CVC matches",creditCard.getCvc(), CVC);
    }

}