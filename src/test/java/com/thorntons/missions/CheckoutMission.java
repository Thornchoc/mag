package com.thorntons.missions;

import com.thorntons.model.UserDetails;
import com.thorntons.pages.CheckoutPage;
import com.thorntons.pages.PaypalPage;
import com.thorntons.pages.components.*;

import javax.inject.Inject;

public class CheckoutMission {

    private HeaderComponent headerComponent;
    private MiniCartComponent miniCartComponent;
    private CheckoutPage checkoutPage;
    private DeliveryForm deliveryForm;
    private LoginForm loginForm;
    private BillingForm billingForm;
    private PaypalPage paypalPage;

    @Inject
    public CheckoutMission(HeaderComponent headerComponent, MiniCartComponent miniCartComponent, CheckoutPage checkoutPage, DeliveryForm deliveryForm, BillingForm billingForm, LoginForm loginForm, PaypalPage paypalPage){
        this.headerComponent = headerComponent;
        this.miniCartComponent = miniCartComponent;
        this.checkoutPage = checkoutPage;
        this.deliveryForm = deliveryForm;
        this.billingForm = billingForm;
        this.loginForm = loginForm;
        this.paypalPage = paypalPage;
    }

    public void goToCheckout(){
        headerComponent.hoverOverCartIcon();
        miniCartComponent.clickCheckoutLink();
    }

    public void checkoutAsGuest() {
        checkoutPage.toggleNewCustomerForm();
        checkoutPage.clickCheckoutAsGuest();
    }

    public void checkoutAsReturningCustomer(String email, String pwd){
        checkoutPage.toggleReturningCustomerForm();
        loginForm.login(email, pwd);
        deliveryForm.clickContinue();
    }

    public void completeDeliveryForm(){
        UserDetails details = new UserDetails();
        details.generateUniqueUser();
        deliveryForm.completeDeliveryForm(details, true);
    }

    public void completeBillingForm(boolean sameAsDelivery){

    }

    public void payWithPaypal(String email, String password){
        billingForm.selectPaypalPayment();
        billingForm.clickPaypalPayNowButton();
        paypalPage.enterEmail(email);
        paypalPage.enterPassword(password);
        paypalPage.clickLoginButton();
    }

    public void checkoutAsNewUser() {
        checkoutPage.toggleNewCustomerForm();
        UserDetails details = new UserDetails();
        details.generateUniqueUser();

    }
}
