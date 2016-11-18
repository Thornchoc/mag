package com.thorntons.missions;

import com.thorntons.context.ScenarioContext;
import com.thorntons.model.UserDetails;
import com.thorntons.pages.AccountPage;
import com.thorntons.pages.components.HeaderComponent;
import com.thorntons.pages.components.LoginForm;
import com.thorntons.pages.components.RegisterForm;

import javax.inject.Inject;

public class AccountMissions {

    private HeaderComponent headerComponent;
    private RegisterForm registerForm;
    private ScenarioContext context;
    private LoginForm loginForm;
    private AccountPage accountPage;

    @Inject
    public AccountMissions(HeaderComponent headerComponent, RegisterForm registerForm, LoginForm loginForm, AccountPage accountPage, ScenarioContext context) {
        this.headerComponent = headerComponent;
        this.registerForm = registerForm;
        this.loginForm = loginForm;
        this.accountPage = accountPage;
        this.context = context;
    }

    public void createNewAccount() {
        headerComponent.clickMyAccountIcon()
                .clickRegisterUserOption();
        UserDetails userDetails = new UserDetails().generateUniqueUser();
        context.setUserDetails(userDetails);
        registerForm.completeRegisterForm(userDetails);
        registerForm.clickApplyButton();
    }

    public void logout() {
        headerComponent
                .clickMyAccountIcon()
                .clickSignOutButton();
    }

    public void login(String email, String password) {
        headerComponent
                .clickMyAccountIcon()
                .clickLoginOption();
        loginForm.login(email, password);
    }

    public boolean isLoggedIn(String name){
        return accountPage.isUserNameDisplayed(name);
    }
}
