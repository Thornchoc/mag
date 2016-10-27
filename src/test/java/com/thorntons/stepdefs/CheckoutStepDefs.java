package com.thorntons.stepdefs;

import com.thorntons.missions.CheckoutMission;
import cucumber.api.java.en.When;

import javax.inject.Inject;

public class CheckoutStepDefs {

    private CheckoutMission checkoutMission;

    @Inject
    public CheckoutStepDefs(CheckoutMission checkoutMission){
        this.checkoutMission = checkoutMission;
    }

    @When("^I checkout as a guest$")
    public void i_checkout_as_a_guest() throws Throwable {
        checkoutMission.goToCheckout();
        checkoutMission.checkoutAsGuest();
        checkoutMission.completeDeliveryForm();
        Thread.sleep(10000);
    }

}
