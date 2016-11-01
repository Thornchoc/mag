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
    }

    @When("^I checkout as a existing user$")
    public void i_checkout_as_a_existing_user() throws Throwable {
        checkoutMission.goToCheckout();
        checkoutMission.checkoutAsReturningCustomer("james.goddard@magentys.io", "password");
    }

    @When("^I checkout as a new user$")
    public void i_checkout_as_a_new_user() throws Throwable {
        checkoutMission.goToCheckout();
        checkoutMission.checkoutAsNewUser();
    }

}
