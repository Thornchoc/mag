package com.thorntons.stepdefs;

import com.thorntons.context.ScenarioContext;
import com.thorntons.missions.CheckoutMissions;
import com.thorntons.model.UserDetails;
import cucumber.api.java.en.When;

import javax.inject.Inject;

public class CheckoutStepDefs {

    private CheckoutMissions checkoutMissions;
    private ScenarioContext context;

    @Inject
    public CheckoutStepDefs(CheckoutMissions checkoutMissions, ScenarioContext context){
        this.checkoutMissions = checkoutMissions;
        this.context = context;
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
        UserDetails userDetails = context.getUserDetails();
        checkoutMissions.checkoutAsReturningCustomer(userDetails.getEmail(), userDetails.getPassword());
    }

    @When("^I checkout as a new user$")
    public void i_checkout_as_a_new_user() throws Throwable {
        checkoutMissions.goToCheckout();
        checkoutMissions.checkoutAsNewUser();
    }

}
