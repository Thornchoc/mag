package com.thorntons.stepdefs;


import com.google.inject.Inject;
import com.thorntons.pages.MultipleProductsPage;
import cucumber.api.java.en.When;

public class MultipleProductsPageStepDefs {

    private final MultipleProductsPage productsPage;

    @Inject
    public MultipleProductsPageStepDefs(MultipleProductsPage productsPage) {
        this.productsPage = productsPage;
    }

    @When("^I select product with name \"(.*)\"$")
    public void i_select_product_with_name(String name) throws Throwable {
        productsPage.selectProductByName(name);
    }
    
}
