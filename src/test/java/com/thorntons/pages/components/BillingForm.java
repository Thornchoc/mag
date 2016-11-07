package com.thorntons.pages.components;

import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.textContains;

public class BillingForm {

    @FindBy(css=".form-row.label-inline>label")
    private PageElement paypalCheckbox;
    @FindBy(css=".button-fancy-large")
    private PageElement paypalPayNowButton;

    public void selectPaypalPayment(){
        paypalCheckbox.waitUntil(displayed.and(textContains("PayPal"))).click();
    }

    public void clickPaypalPayNowButton(){
        paypalPayNowButton.waitUntil(displayed.and(enabled)).click();
    }

}
