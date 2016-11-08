package com.thorntons.stepdefs;

import com.thorntons.missions.CheckoutMission;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;

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

    @When("^I pay with (Visa|Amex)$")
    public void i_pay_with_visa(String cardType) throws Throwable {
        checkoutMission.enterPaymentCardDetails(cardType);
        checkoutMission.cofirmAndCompleteOrder();
    }

    @Then("^my order should be complete$")
    public void my_order_should_be_complete() throws Throwable {
        assertThat("should see order confirmation", checkoutMission.wasOrderSuccessful());
    }

}
