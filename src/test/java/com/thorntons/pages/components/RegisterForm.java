package com.thorntons.pages.components;

import com.thorntons.model.UserDetails;
import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.ReadyState;
import io.magentys.cinnamon.webdriver.conditions.Conditions;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;

public class RegisterForm {

    @FindBy(id = "dwfrm_profile_customer_firstname")
    private PageElement firstNameInput;
    @FindBy(id = "dwfrm_profile_customer_lastname")
    private PageElement lastNameInput;
    @FindBy(id = "dwfrm_profile_customer_email")
    private PageElement emailInput;
    @FindBy(id = "dwfrm_profile_customer_emailconfirm")
    private PageElement confirmEmailInput;
    @FindBy(css = "[id^=dwfrm_profile_login_password]")
    private PageElement passwordInput;
    @FindBy(css = "[id^=dwfrm_profile_login_passwordconfirm]")
    private PageElement confirmPasswordInput;
    @FindBy(css = ".spc-registration-btn")
    private PageElement continueButton;
    @FindBy(name = "dwfrm_profile_confirm")
    private PageElement applyButton;

    public void completeForm(UserDetails details){
        enterFirstName(details.getFirstName());
        enterLastName(details.getLastName());
        enterEmailAddress(details.getEmail());
        enterConfirmEmailAddress(details.getEmail());
        enterPassword(details.getPassword());
        enterConfirmPassword(details.getPassword());
    }

    public void enterConfirmPassword(String password) {
        confirmPasswordInput.clear();
        confirmPasswordInput.typeText(password);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.typeText(password);
    }

    public void enterFirstName(String fName){
        firstNameInput.waitUntil(displayed.and(enabled)).clear();
        firstNameInput.typeText(fName);
    }

    public void enterLastName(String lName){
        lastNameInput.clear();
        lastNameInput.typeText(lName);
    }

    public void enterEmailAddress(String email) {
        emailInput.clear();
        emailInput.typeText(email);
    }

    public void enterConfirmEmailAddress(String email) {
        confirmEmailInput.clear();
        confirmEmailInput.typeText(email);
    }


    public void clickContinueButton() {
        continueButton.waitUntil(enabled).click();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
    }

    public void clickApplyButton() {
        applyButton.waitUntil(enabled).click();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
    }
}
