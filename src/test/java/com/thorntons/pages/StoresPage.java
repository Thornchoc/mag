package com.thorntons.pages;

import io.magentys.cinnamon.webdriver.elements.PageElement;

import org.openqa.selenium.support.FindBy;

public class StoresPage {

    @FindBy(id = "dwfrm_storelocator_postalCode")
    public PageElement postcodeField;

    @FindBy(css = "button[value=\"Search\"]")
    public PageElement searchButton;

    @FindBy(css = "div[class=\"your-search-found\"]")
    public PageElement resultsTitle;

    @FindBy(name = "dwfrm_storelocator_county")
    private PageElement countyDropDown;

    @FindBy(name = "dwfrm_storelocator_findbystate")
    private PageElement countySearch;

    @FindBy(name = "dwfrm_storelocator_maxdistance")
    private PageElement radiusDropDown;

    @FindBy(id = "521")
    private PageElement shopStoreDetailsLink;

    @FindBy(css = "div[class=\"store-address\"]")
    private PageElement shopStoreAddressDetails;

    @FindBy(css = "div[class=\"google-map-wrapper\"]")
    private PageElement shopStoreGoogleMap;

    public void enterPostcode(String postcode) {
        postcodeField.fillIn(postcode);
    }

    public void clickSearch() {
        searchButton.click();

    }

    public boolean checkResults() {
        return resultsTitle.getText().contains("Your Search Found 5 Stores");

    }

    public StoresPage selectCounty(String county) {
        countyDropDown.select().byVisibleTextContains(county);
        return this;

    }

    public StoresPage clickCountySearch() {
        countySearch.click();
        return this;

    }

    public boolean checkCountyResults() {
        return resultsTitle.getText().contains("Your Search Found 6 Stores");
    }

    public StoresPage selectRadius(Integer radius) {
        String rad = radius.toString();
        radiusDropDown.select().byVisibleTextContains(rad);
        return this;

    }

    public boolean checkCountyResultsBasedOnRadius() {
        return resultsTitle.getText().contains("Your Search Found 35 Stores");
    }

    public StoresPage clickStoreDetails(String storeID) {
        shopStoreDetailsLink.click();
        return this;

    }

    public boolean checkStoreAddressInformation() {
        return shopStoreAddressDetails.getText().contains("160 High Street");

    }

    public boolean checkStoreGoogleMap() {
        return shopStoreGoogleMap.isPresent();
    }

}