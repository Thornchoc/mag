package com.thorntons.missions;

import com.thorntons.model.UserDetails;
import com.thorntons.pages.CheckoutPage;
import com.thorntons.pages.components.*;

import javax.inject.Inject;

public class CheckoutMission {

    private HeaderComponent headerComponent;
    private MiniCartComponent miniCartComponent;
    private CheckoutPage checkoutPage;
    private DeliveryForm deliveryForm;
    private LoginForm loginForm;
    private BillingForm billingForm;

    @Inject
    public CheckoutMission(HeaderComponent headerComponent, MiniCartComponent miniCartComponent, CheckoutPage checkoutPage, DeliveryForm deliveryForm, BillingForm billingForm, LoginForm loginForm){
        this.headerComponent = headerComponent;
        this.miniCartComponent = miniCartComponent;
        this.checkoutPage = checkoutPage;
        this.deliveryForm = deliveryForm;
        this.billingForm = billingForm;
        this.loginForm = loginForm;
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

    }

    public void checkoutAsNewUser() {
        checkoutPage.toggleNewCustomerForm();
        UserDetails details = new UserDetails();
        details.generateUniqueUser();

    }
}
