package com.thorntons.stepdefs;

import javax.inject.Inject;

//import junit.framework.Assert;
import org.junit.Assert;

import com.thorntons.pages.StoresPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StoresStepDefs {

    private final StoresPage storesPage;

    @Inject
    public StoresStepDefs(final StoresPage storesPage) {
        this.storesPage = storesPage;
    }

    @When("^I enter my postcode$")
    public void i_enter_my_postcode() throws Throwable {
        storesPage.enterPostcode("SM6 8QG");
    }

    @Then("^I can see a shop near me$")
    public void i_can_see_a_shop_near_me() throws Throwable {
        storesPage.clickSearch();
        Assert.assertTrue("Store number results is incorrect",
                storesPage.checkResults());
    }
    
    @When("^I select my County$")
    public void i_select_my_County() throws Throwable {
        storesPage.selectCounty("Surrey");
    }
    
    @Then("^I can see all the shops in my county$")
    public void i_can_see_all_the_shops_in_my_county() throws Throwable {
        Assert.assertTrue("Store number results is incorrect",
                storesPage.checkResults());
    }

}