package com.thorntons.pages.components;

import com.thorntons.model.UserDetails;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

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

    public void completeRegisterForm(UserDetails details){
        enterFirstName(details.getFirstName());
        enterLastName(details.getLastName());
        enterEmailAddress(details.getEmail());
        enterConfirmEmailAddress(details.getEmail());
        enterPassword(details.getPassword());
        enterConfirmPassword(details.getPassword());
    }

    private void enterConfirmPassword(String password) {
        confirmEmailInput.typeText(password);
    }

    private void enterPassword(String password) {
        passwordInput.typeText(password);
    }

    public void enterFirstName(String fName){
        firstNameInput.typeText(fName);
    }

    public void enterLastName(String lName){
        lastNameInput.typeText(lName);
    }

    private void enterEmailAddress(String email) {
        emailInput.typeText(email);
    }

    private void enterConfirmEmailAddress(String email) {
        confirmEmailInput.typeText(email);
    }



}
