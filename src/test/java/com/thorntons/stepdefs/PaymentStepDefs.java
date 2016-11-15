package com.thorntons.stepdefs;

import com.thorntons.missions.CheckoutMissions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;

public class PaymentStepDefs {

    private CheckoutMissions checkoutMissions;

    @Inject
    public PaymentStepDefs(CheckoutMissions checkoutMissions){
        this.checkoutMissions = checkoutMissions;
    }


    @When("^I pay with paypal$")
    public void i_pay_with_paypal() throws Throwable {
        checkoutMissions.payWithPaypal("aimee.white-buyer@thorntons.co.uk", "chocolate");
    }

    @When("^I pay with (Visa|Amex|MasterCard)$")
    public void i_pay_with_visa(String cardType) throws Throwable {
        checkoutMissions.enterPaymentCardDetails(cardType);
        checkoutMissions.cofirmAndCompleteOrder();
    }

    @Then("^my order should be complete$")
    public void my_order_should_be_complete() throws Throwable {
        assertThat("should see order confirmation", checkoutMissions.wasOrderSuccessful());
    }

}
