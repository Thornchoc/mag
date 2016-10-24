package com.thorntons.stepdefs;


import com.google.inject.Inject;
import com.thorntons.pages.ShoppingBagPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingBagStepDefs {
    
    private final ShoppingBagPage shoppingBagPage;

    @Inject
    public ShoppingBagStepDefs(ShoppingBagPage shoppingBagPage) {
        this.shoppingBagPage = shoppingBagPage;
    }

    @Then("^I should see the product in my bag$")
    public void i_should_see_the_product_in_my_bag() throws Throwable {
        shoppingBagPage.verifyShoppingBag();
    }

    @When("^I go to Checkout$")
    public void i_go_to_Checkout() throws Throwable {
        shoppingBagPage.checkOut();
    }
}
