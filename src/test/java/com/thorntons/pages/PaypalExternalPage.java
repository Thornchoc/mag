package com.thorntons.pages;

import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.ReadyState;
import io.magentys.cinnamon.webdriver.conditions.Conditions;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;

public class PaypalExternalPage {

    @FindBy(css = "form #email")
    private PageElement emailInput;
    @FindBy(css = "form #password")
    private PageElement passwordInput;
    @FindBy(name = "btnLogin")
    private PageElement loginButton;
    @FindBy(id = "confirmButtonTop")
    private PageElement confirmButton;
    @FindBy(id = "preloaderSpinner")
    private PageElement loadingSpinner;

    public void enterEmail(String email){
        emailInput.waitUntil(displayed.and(enabled)).click();
        emailInput.clear();
        emailInput.typeText(email);
    }

    public void enterPassword(String password){
        passwordInput.typeText(password);
    }

    public void clickLoginButton(){
        loginButton.click();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
    }

    public void clickConfirmButton(){
        confirmButton.waitUntil(displayed.and(enabled)).click();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
    }



}
