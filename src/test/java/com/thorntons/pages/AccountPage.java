package com.thorntons.pages;

import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.textContains;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.textContainsIgnoreCase;

public class AccountPage {

    @FindBy(css = "#primary > .h1 ")
    private PageElement myAccountTitle;

    public boolean isUserNameDisplayed(String name){
        return myAccountTitle.waitUntil((textContainsIgnoreCase(name))).isDisplayed();
    }
}
