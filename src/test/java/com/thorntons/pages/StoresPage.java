package com.thorntons.pages;

import io.magentys.cinnamon.conf.Env;
import io.magentys.cinnamon.webdriver.elements.PageElement;

import javax.inject.Inject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.thorntons.context.ThorntonsContext;

public class StoresPage {

    protected final ThorntonsContext context;
    protected final Env env;
    public WebDriver webDriver;

    @Inject
    public StoresPage(final Env env, WebDriver webDriver,
            final ThorntonsContext context) {
        this.env = env;
        this.webDriver = webDriver;
        this.context = context;
    }

    @FindBy(id = "dwfrm_storelocator_postalCode")
    public PageElement postcodeField;

    @FindBy(css = "button[value=\"Search\"]")
    public PageElement searchButton;

    @FindBy(css = "div[class=\"your-search-found\"]")
    public PageElement resultsTitle;

    @FindBy(id = "dwfrm_storelocator_county")
    private PageElement countyDropDown;

    public void enterPostcode(String postcode) {
        postcodeField.fillIn(postcode);

    }

    public void clickSearch() {
        searchButton.click();

    }

    public boolean checkResults() {
        return resultsTitle.getText().contains("Your Search Found 5 Stores");

    }

    public void selectCounty(String county) {
        countyDropDown.select().byVisibleText(county);

    }

}