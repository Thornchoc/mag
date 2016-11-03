package com.thorntons.stepdefs;


import com.google.inject.Inject;
import com.thorntons.missions.ShoppingMission;
import com.thorntons.pages.ShoppingBagPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingBagStepDefs {
    
    private final ShoppingBagPage shoppingBagPage;
    private final ShoppingMission shoppingMission;

    @Inject
    public ShoppingBagStepDefs(ShoppingBagPage shoppingBagPage, final ShoppingMission shoppingMission) {
        this.shoppingBagPage = shoppingBagPage;
        this.shoppingMission = shoppingMission;
    }

    @Then("^I should see the product in my bag$")
    public void i_should_see_the_product_in_my_bag() throws Throwable {
        shoppingBagPage.verifyShoppingBag();
    }

    @When("^I go to Checkout$")
    public void i_go_to_Checkout() throws Throwable {
        shoppingBagPage.checkOut();
    }

    @Given("^I have added a product to my shopping bag$")
    public void i_have_added_a_product_to_my_shopping_bag() throws Throwable {
        shoppingMission.search("Original Special Toffee Box");
        shoppingMission.addToBasket();

    }

}
