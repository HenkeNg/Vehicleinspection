package se.kth.iv1350.vehicleInspection.integration;

import se.kth.iv1350.vehicleInspection.model.CreditCard;

/**
 * Created by henri on 02/05/2017.
 * Represents the external payment authorization for payment with a credit card.
 */
public class ExternalAuthorizationCenter {

    /**
     * A method for Authorization, for this lab, we will always return true I.E
     * Cards will always be authorized. We would have to compare the amount inside the creditcard
     * @param card The credit card that requests the authorization
     * @param cost The cost invoked on the credit card.
     * @return boolean, that is always true in our exercise
     */
    public boolean externalAuthor(CreditCard card, ItemInspectionList cost ){ return true; }
}
