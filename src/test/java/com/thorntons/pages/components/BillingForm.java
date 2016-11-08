package com.thorntons.pages.components;

import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.ReadyState;
import io.magentys.cinnamon.webdriver.conditions.Conditions;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.textContains;
import static org.bouncycastle.asn1.x509.X509ObjectIdentifiers.id;

public class BillingForm {

    @FindBy(css=".form-row.label-inline>label")
    private PageElement paypalCheckbox;
    @FindBy(css=".button-fancy-large")
    private PageElement paypalPayNowButton;
    @FindBy(id = "dwfrm_billing_paymentMethods_creditCard_owner")
    private PageElement paymentCardNameInput;
    @FindBy(id = "dwfrm_billing_paymentMethods_creditCard_type")
    private PageElement cardTypeDropDown;
    @FindBy(css ="[id^=dwfrm_billing_paymentMethods_creditCard_number]")
    private PageElement cardNumberInput;
    @FindBy(id = "dwfrm_billing_paymentMethods_creditCard_issueno")
    private PageElement issueNumberInput;
    @FindBy(css = "[id^=dwfrm_billing_paymentMethods_creditCard_cvn_]")
    private PageElement cVVInput;
    @FindBy(id = "dwfrm_billing_paymentMethods_creditCard_expiration_year")
    private PageElement expiryYearDropDown;
    @FindBy(name = "dwfrm_billing_save")
    private PageElement payNowButton;

    public BillingForm selectPaypalPayment(){
        paypalCheckbox.waitUntil(displayed.and(textContains("PayPal"))).click();
        return this;
    }

    public BillingForm clickPaypalPayNowButton(){
        paypalPayNowButton.waitUntil(displayed.and(enabled)).click();
        return this;
    }

    public BillingForm selectCardType(String cardType){
        cardTypeDropDown.select().byVisibleText(cardType);
        return this;
    }

    public BillingForm enterNameOnCard(String james) {
        paymentCardNameInput.waitUntil(displayed.and(enabled)).typeText(james);
        return this;
    }

    public BillingForm enterCardNumber(String cardNumber){
        cardNumberInput.typeText(cardNumber);
        return this;
    }

    public BillingForm enterIssueNumber(String issueNumber){
        if(issueNumber == null || issueNumber == "") {
            return this;
        }
        issueNumberInput.typeText(issueNumber);
        return this;
    }

    public BillingForm enterCVV(String cVV){
        cVVInput.typeText(cVV);
        return this;
    }

    public BillingForm selectExpiryYear(String expiryYear){
        expiryYearDropDown.select().byVisibleText(expiryYear);
        return this;
    }

    public BillingForm clickPayNow(){
        payNowButton.waitUntil(displayed.and(enabled)).click();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
        return this;
    }

}
