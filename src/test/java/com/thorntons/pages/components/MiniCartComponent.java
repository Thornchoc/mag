package com.thorntons.pages.components;

import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.ReadyState;
import io.magentys.cinnamon.webdriver.conditions.Conditions;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

public class MiniCartComponent {

    @FindBy(css = ".mini-cart-link-checkout")
    private PageElement checkoutLink;

    public void clickCheckoutLink() {
        checkoutLink.click();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
    }
}
