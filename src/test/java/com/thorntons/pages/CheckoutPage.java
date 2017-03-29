package com.thorntons.pages;

import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.ReadyState;
import io.magentys.cinnamon.webdriver.conditions.Conditions;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;

public class CheckoutPage {

    @FindBy(css = ".toggle-new-customer")
    private PageElement newCustomerFormToggle;
    @FindBy(css = ".spc-guest-btn")
    private PageElement checkoutGuestButton;
    @FindBy(css = ".toggle-logged-in-customer")
    private PageElement returningCustomerFormToggle;

    public void toggleNewCustomerForm() {
        newCustomerFormToggle.waitUntil(displayed.and(enabled)).click();
    }

    public void toggleReturningCustomerForm() {
        returningCustomerFormToggle.waitUntil(displayed.and(enabled)).click();
    }

    public void clickCheckoutAsGuest() {
        checkoutGuestButton.waitUntil(displayed.and(enabled)).click();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
    }

}
