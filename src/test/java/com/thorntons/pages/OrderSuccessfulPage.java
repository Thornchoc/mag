package com.thorntons.pages;

import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.textContainsIgnoreCase;

public class OrderSuccessfulPage {

    @FindBy(css = "#primary>h1")
    private PageElement thanksForOrderH1;

    public boolean isSuccessful() {
        return thanksForOrderH1.is(textContainsIgnoreCase("Thank you for your order!").and(displayed));
    }
}
