package com.thorntons.missions;

import com.thorntons.context.ScenarioContext;
import com.thorntons.model.UserDetails;
import com.thorntons.pages.AccountPage;
import com.thorntons.pages.AddressPage;
import com.thorntons.pages.components.*;
import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.ReadyState;
import io.magentys.cinnamon.webdriver.conditions.Conditions;

import javax.inject.Inject;

import static io.magentys.cinnamon.webdriver.Browser.sleep;

public class AccountMissions {

    private HeaderComponent headerComponent;
    private RegisterForm registerForm;
    private ScenarioContext context;
    private LoginForm loginForm;
    private AccountPage accountPage;
    private EditAccountForm editAccountForm;
    private AddressPage addressPage;
    private AddAddressForm addAddressForm;

    @Inject
    public AccountMissions(HeaderComponent headerComponent, RegisterForm registerForm, LoginForm loginForm, AccountPage accountPage, ScenarioContext context, EditAccountForm editAccountForm, AddressPage addressPage, AddAddressForm addAddressForm) {
        this.headerComponent = headerComponent;
        this.registerForm = registerForm;
        this.loginForm = loginForm;
        this.accountPage = accountPage;
        this.context = context;
        this.editAccountForm = editAccountForm;
        this.addressPage = addressPage;
        this.addAddressForm = addAddressForm;
    }

    public void createNewAccount() {
        headerComponent.clickMyAccountIcon()
                .clickRegisterUserOption();
        UserDetails userDetails = new UserDetails().generateUniqueUser();
        context.setUserDetails(userDetails);
        registerForm.completeForm(userDetails);
        registerForm.clickApplyButton();
    }

    public void logout() {
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE).and(Conditions.ajaxFinished));
        sleep(5000);
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

    public void changeEmail() {
        headerComponent.clickMyAccountIcon();
        accountPage.clickPersonalDataOption();
        UserDetails user = context.getUserDetails();
        user.setEmail(UserDetails.generateUniqueEmail());
        context.setUserDetails(user);
        editAccountForm.completeForm(user);
        editAccountForm.clickApplyButton();
    }

    public void addAddress() {
        headerComponent.clickMyAccountIcon();
        accountPage.clickAddressesOption();
        addressPage.clickCreateNewAddressButton();
        UserDetails user = context.getUserDetails();
        addAddressForm.completeAddressForm(user);
        addAddressForm.clickApply();
    }

    public boolean isAddressDisplayed(){
        UserDetails user = context.getUserDetails();
        return addressPage.isAddressListed(user.getAddressName());
    }
}
