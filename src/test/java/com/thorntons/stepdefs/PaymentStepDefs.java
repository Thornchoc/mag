package com.thorntons.stepdefs;

import com.thorntons.missions.CheckoutMission;
import cucumber.api.java.en.When;

import javax.inject.Inject;

public class PaymentStepDefs {

    private CheckoutMission checkoutMission;

    @Inject
    public PaymentStepDefs(CheckoutMission checkoutMission){
        this.checkoutMission = checkoutMission;
    }


    @When("^I pay with paypal$")
    public void i_pay_with_paypal() throws Throwable {
        checkoutMission.payWithPaypal("aimee.white-buyer@thorntons.co.uk", "chocolate");
    }


}
