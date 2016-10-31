package com.thorntons.missions;

import com.thorntons.model.UserDetails;
import com.thorntons.pages.CheckoutPage;
import com.thorntons.pages.components.DeliveryForm;
import com.thorntons.pages.components.HeaderComponent;
import com.thorntons.pages.components.MiniCartComponent;

import javax.inject.Inject;

public class CheckoutMission {

    private HeaderComponent headerComponent;
    private MiniCartComponent miniCartComponent;
    private CheckoutPage checkoutPage;
    private DeliveryForm deliveryForm;

    @Inject
    public CheckoutMission(HeaderComponent headerComponent, MiniCartComponent miniCartComponent, CheckoutPage checkoutPage, DeliveryForm deliveryForm){
        this.headerComponent = headerComponent;
        this.miniCartComponent = miniCartComponent;
        this.checkoutPage = checkoutPage;
        this.deliveryForm = deliveryForm;
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

    }

    public void completeDeliveryForm(){
        UserDetails details = new UserDetails();
        details.generateUniqueDetails();
        deliveryForm.completeDeliveryForm(details, true);

    }

    public void completeBillingForm(boolean sameAsDelivery){


    }
}
