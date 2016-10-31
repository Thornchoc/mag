package com.thorntons.stepdefs;

import com.google.inject.Inject;
import com.thorntons.pages.ProductDetailsPage;
import cucumber.api.java.en.When;


public class SingleProductPageStepDefs {
    
    ProductDetailsPage productDetailsPage;
    
    @Inject
    public SingleProductPageStepDefs(ProductDetailsPage productDetailsPage) {
        this.productDetailsPage = productDetailsPage;
    }


    @When("^I add (?:it|product) to the bag$")
    public void i_add_it_to_the_bag() throws Throwable {
        productDetailsPage.clickAddToBag();
    }

    @When("^I view my bag$")
    public void i_view_my_bag() throws Throwable {
        productDetailsPage.viewCart();
    }
}
