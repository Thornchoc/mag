package com.thorntons.missions;

import com.thorntons.model.CardDetails;
import com.thorntons.model.UserDetails;
import com.thorntons.pages.CheckoutPage;
import com.thorntons.pages.OrderSuccessfulPage;
import com.thorntons.pages.PaypalExternalPage;
import com.thorntons.pages.components.*;
import com.thorntons.services.CardDetailsService;
import io.magentys.cinnamon.webdriver.Browser;

import javax.inject.Inject;

public class CheckoutMissions {

    private HeaderComponent headerComponent;
    private MiniCartComponent miniCartComponent;
    private CheckoutPage checkoutPage;
    private DeliveryForm deliveryForm;
    private LoginForm loginForm;
    private BillingForm billingForm;
    private PaypalExternalPage paypalExternalPage;
    private OrderReview orderReview;
    private OrderSuccessfulPage orderSuccessfulPage;
    private RegisterForm registerForm;

    @Inject
    public CheckoutMissions(HeaderComponent headerComponent, MiniCartComponent miniCartComponent, CheckoutPage checkoutPage, DeliveryForm deliveryForm, BillingForm billingForm, LoginForm loginForm, PaypalExternalPage paypalExternalPage, OrderReview orderReview, OrderSuccessfulPage orderSuccessfulPage, RegisterForm registerForm) {
        this.headerComponent = headerComponent;
        this.miniCartComponent = miniCartComponent;
        this.checkoutPage = checkoutPage;
        this.deliveryForm = deliveryForm;
        this.billingForm = billingForm;
        this.loginForm = loginForm;
        this.paypalExternalPage = paypalExternalPage;
        this.orderReview = orderReview;
        this.orderSuccessfulPage = orderSuccessfulPage;
        this.registerForm = registerForm;
    }

    public void goToCheckout() {
        headerComponent.hoverOverCartIcon();
        miniCartComponent.clickCheckoutLink();
    }

    public void checkoutAsGuest() {
        checkoutPage.toggleNewCustomerForm();
        checkoutPage.clickCheckoutAsGuest();
    }

    public void checkoutAsReturningCustomer(String email, String pwd) {
        checkoutPage.toggleReturningCustomerForm();
        loginForm.login(email, pwd);
        deliveryForm.clickContinue();
    }

    public void completeDeliveryForm() {
        UserDetails details = new UserDetails();
        details.generateUniqueUser();
        deliveryForm.completeDeliveryForm(details, true);
    }

    public void completeBillingForm(boolean sameAsDelivery) {

    }

    public void payWithPaypal(String email, String password) {
        billingForm.selectPaypalPayment()
                .clickPaypalPayNowButton();
        paypalExternalPage.enterEmail(email);
        paypalExternalPage.enterPassword(password);
        paypalExternalPage.clickLoginButton();
    }

    public void checkoutAsNewUser() {
        checkoutPage.toggleNewCustomerForm();
        UserDetails details = new UserDetails();
        details.generateUniqueUser();
        registerForm.completeRegisterForm(details);
        registerForm.clickContinueButton();
        deliveryForm.completeDeliveryForm(details, true);
    }

    public void enterPaymentCardDetails(String cardType) {
        CardDetails cardDetails = new CardDetailsService().getCardByType(cardType);
        billingForm.enterNameOnCard("James")
                .selectCardType(cardDetails.getCardType())
                .enterCardNumber(cardDetails.getCardNumber())
                .enterIssueNumber(cardDetails.getIssueNumber())
                .enterCVV(cardDetails.getcVV())
                .selectExpiryYear("2018")
                .clickPayNow();
    }

    public void cofirmAndCompleteOrder(){
        orderReview.clickOrderNow();
    }

    public boolean wasOrderSuccessful(){
        return orderSuccessfulPage.isSuccessful();
    }
}
