package com.thorntons.pages;

import io.magentys.cinnamon.webdriver.collections.PageElementCollection;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import io.magentys.cinnamon.webdriver.support.FindByKey;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.*;

public class AccountPage {

    @FindBy(css = "#primary > .h1 ")
    private PageElement myAccountTitle;
    @FindBy(css = ".account-options>li>a>h2")
    private PageElementCollection accountOptions;

    public boolean isUserNameDisplayed(String name) {
        return myAccountTitle.waitUntil((textContainsIgnoreCase(name))).isDisplayed();
    }

    public void clickPersonalDataOption() {
        clickAccountOption("Personal Data");
    }

    public void clickAccountOption(String option) {
        accountOptions.first(textContainsIgnoreCase(option).and(displayed).and(enabled)).click();
    }

    public void clickAddressesOption() {
        clickAccountOption("Addresses");
    }
}
