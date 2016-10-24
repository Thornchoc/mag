package com.thorntons.stepdefs;

import com.google.inject.Inject;
import com.thorntons.pages.SingleProductPage;
import cucumber.api.java.en.When;


public class SingleProductPageStepDefs {
    
    SingleProductPage singleProductPage;
    
    @Inject
    public SingleProductPageStepDefs(SingleProductPage singleProductPage) {
        this.singleProductPage = singleProductPage;
    }


    @When("^I add (?:it|product) to the bag$")
    public void i_add_it_to_the_bag() throws Throwable {
        singleProductPage.addtoBag();
    }

    @When("^I view my bag$")
    public void i_view_my_bag() throws Throwable {
        singleProductPage.viewCart();
    }
}
