package com.thorntons.pages.components;

import com.thorntons.model.UserDetails;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;

public class DeliveryForm {

    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_country")
    private PageElement countryDropDown;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_firstName")
    private PageElement firstNameInput;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_lastName")
    private PageElement lastNameInput;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_address1")
    private PageElement address1Input;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_city")
    private PageElement cityInput;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_postal")
    private PageElement postCodeInput;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_phone")
    private PageElement phoneInput;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_email_emailAddress")
    private PageElement emailInput;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_useAsBillingAddress")
    private PageElement sameAsBillingCheckBox;

    public void completeDeliveryForm(UserDetails details, boolean sameAsBilling){
        selectCountry(details.getCountry());
        enterFirstName(details.getFirstName());
        enterLastName(details.getLastName());
        enterAddress(details.getAddress1());
        enterCity(details.getCity());
        enterPostCode(details.getPostalCode());
        enterPhoneNumber(details.getPhone());
        enterEmailAddress(details.getEmail());
        if(sameAsBilling){
            selectSameAsDelivery();
            return;
        }
        clickContinue();
    }

    public void selectCountry(String country){
        countryDropDown.waitUntil(displayed.and(enabled)).select().byVisibleText(country);
    }

    public void enterFirstName(String fName){
        firstNameInput.typeText(fName);
    }

    public void enterLastName(String lName){
        lastNameInput.typeText(lName);
    }

    public void enterAddress(String address){
        address1Input.typeText(address);
    }

    public void enterCity(String city){
        cityInput.typeText(city);
    }

    public void enterPostCode(String postCode){
        postCodeInput.typeText(postCode);
    }

    public void enterPhoneNumber(String number){
        phoneInput.typeText(number);
    }

    public void enterEmailAddress(String email){
        emailInput.typeText(email);
    }

    public void selectSameAsDelivery(){
        if(!sameAsBillingCheckBox.isSelected())
            sameAsBillingCheckBox.click();
    }

    public void clickContinue(){

    }

}
