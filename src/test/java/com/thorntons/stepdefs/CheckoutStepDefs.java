package com.thorntons.stepdefs;

import com.thorntons.missions.CheckoutMissions;
import cucumber.api.java.en.When;

import javax.inject.Inject;

public class CheckoutStepDefs {

    private CheckoutMissions checkoutMissions;

    @Inject
    public CheckoutStepDefs(CheckoutMissions checkoutMissions){
        this.checkoutMissions = checkoutMissions;
    }

    @When("^I checkout as a guest$")
    public void i_checkout_as_a_guest() throws Throwable {
        checkoutMissions.goToCheckout();
        checkoutMissions.checkoutAsGuest();
        checkoutMissions.completeDeliveryForm();
    }

    @When("^I checkout as a existing user$")
    public void i_checkout_as_a_existing_user() throws Throwable {
        checkoutMissions.goToCheckout();
        checkoutMissions.checkoutAsReturningCustomer("james.goddard+@magentys.io", "password");
    }

    @When("^I checkout as a new user$")
    public void i_checkout_as_a_new_user() throws Throwable {
        checkoutMissions.goToCheckout();
        checkoutMissions.checkoutAsNewUser();
    }

}
