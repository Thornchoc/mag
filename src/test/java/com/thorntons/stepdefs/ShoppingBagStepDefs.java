package com.thorntons.stepdefs;


import com.google.inject.Inject;
import com.thorntons.missions.ShoppingMission;
import com.thorntons.pages.ShoppingBagPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.ReadyState;
import io.magentys.cinnamon.webdriver.conditions.Conditions;
import org.openqa.selenium.WebDriver;

public class ShoppingBagStepDefs {
    
    private final ShoppingBagPage shoppingBagPage;
    private final ShoppingMission shoppingMission;
    private WebDriver webDriver;

    @Inject
    public ShoppingBagStepDefs(ShoppingBagPage shoppingBagPage, final ShoppingMission shoppingMission, WebDriver webDriver) {
        this.shoppingBagPage = shoppingBagPage;
        this.shoppingMission = shoppingMission;
        this.webDriver = webDriver;
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
        //shoppingMission.searchAndSelect("Original Special Toffee Box");
        webDriver.get("https://staging-store-thorntons.demandware.net/s/Thorntons/get-well-soon-gifts/original-special-toffee-box-525g-3311.html#q=Original+Special+Toffee+Box+(525g)+&lang=default&start=2");
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
        shoppingMission.addToBasket();

    }

}
