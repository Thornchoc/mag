package com.thorntons.pages.components;

import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.ReadyState;
import io.magentys.cinnamon.webdriver.conditions.Conditions;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.textContainsIgnoreCase;

public class OrderReview {

    @FindBy(css = ".button-fancy-large.spc-placeorder-btn")
    private PageElement orderNowButton;

    public OrderReview clickOrderNow() {
        orderNowButton.waitUntil(displayed.and(enabled).and(textContainsIgnoreCase("Submit Order"))).click();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
        return this;
    }
}
