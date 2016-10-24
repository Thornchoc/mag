package com.thorntons.stepdefs;

import javax.inject.Inject;

import com.thorntons.pages.HomePage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefs {

    private final HomePage homePage;

    @Inject
    public HomePageStepDefs(final HomePage homePage) {
        this.homePage = homePage;
    }

    
    @Given("^I am on Thorntons home page$")
    public void i_am_on_Thorntons_home_page() throws Throwable {
        homePage.waitUntilOpened();
    }
    
    @When("^I select category \"(Gifts & Occasions|Chocolates|Our Shops|Our Crafts)\"$")
    public void i_select_category(String category) throws Throwable {
        homePage.selectCategory(category.toLowerCase());
    }

    @When("^I select chocolate type \"(.*)\"$")
    public void i_select_chocolate_type(String type) throws Throwable {
        //String typeAdjusted = encodeCharInUrl("space", type);
        //homePage.selectType(typeAdjusted.toLowerCase());
        String typeDashesForSpaces = type.replace(" ", "-");
        homePage.selectType(typeDashesForSpaces.toLowerCase());
    }
    

    /**
     * * Encodes particular characters for URL's. At the moment only the space character.
     * Please add more if and when needed :-), or implement the whole list 
     * in the switch statement if time allows!
     *
     * For a list of URL encodings, and the characters to encode, please see 
     * http://www.degraeve.com/reference/urlencoding.php
     * @param charToEncode
     * @param urlOrPartsOfIt
     * @return
     */
    public String encodeCharInUrl(String charToEncode, String urlOrPartsOfIt) {
        String adjusted = null;
        switch(charToEncode) {
            case "space":
                adjusted = urlOrPartsOfIt.replaceAll(" ", "%20");
                break;
            default:
                adjusted = urlOrPartsOfIt;
        }
        return adjusted;
    }
    
}