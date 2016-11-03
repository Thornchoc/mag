package com.thorntons.stepdefs;

import com.thorntons.missions.CheckoutMission;
import cucumber.api.java.en.When;

public class PaymentStepDefs {

    private CheckoutMission checkoutMission;

    public PaymentStepDefs(CheckoutMission checkoutMission){
        this.checkoutMission = checkoutMission;
    }


    @When("^I pay with paypal$")
    public void i_pay_with_paypal() throws Throwable {
        checkoutMission.payWithPaypal("aimee.white-buyer@thorntons.co.uk", "chocolate");
    }


}
