package com.thorntons.pages.components;

import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;

public class LoginForm {

    @FindBy(id = "dwfrm_login_username")
    private PageElement emailInput;
    @FindBy(css = "[id^= dwfrm_login_password]")
    private PageElement passwordInput;

    public void Login(String email, String pwd){

    }

    public void enterEmail(String email){
        emailInput.waitUntil(displayed.and(enabled)).typeText(email);
    }

    public void enterPassword(String password){
        passwordInput.waitUntil(displayed.and(enabled)).typeText(password);
    }
}
