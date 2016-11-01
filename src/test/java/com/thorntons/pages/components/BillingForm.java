package com.thorntons.pages.components;

import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;

public class BillingForm {

    @FindBy(id="is-PayPal")
    private PageElement paypalCheckbox;
    @FindBy(css=".button-fancy-large")
    private PageElement paypalPayNowButton;

    public void selectPaypalPayment(){
        paypalCheckbox.waitUntil(displayed.and(enabled)).click();
    }

    public void clickPaypalPayNowButton(){
        paypalPayNowButton.waitUntil(displayed.and(enabled));
    }

}
