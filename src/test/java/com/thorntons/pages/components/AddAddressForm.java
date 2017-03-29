package com.thorntons.pages.components;

import com.thorntons.model.UserDetails;
import gherkin.lexer.Pa;
import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.ReadyState;
import io.magentys.cinnamon.webdriver.conditions.Conditions;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;

public class AddAddressForm {

    @FindBy(id = "dwfrm_profile_address_country")
    private PageElement countryDropDown;
    @FindBy(id = "dwfrm_profile_address_addressid")
    private PageElement addressNameInput;
    @FindBy(id = "dwfrm_profile_address_firstname")
    private PageElement firstNameInput;
    @FindBy(id = "dwfrm_profile_address_lastname")
    private PageElement lastNameInput;
    @FindBy(id = "dwfrm_profile_address_address1")
    private PageElement address1Input;
    @FindBy(id = "dwfrm_profile_address_city")
    private PageElement cityInput;
    @FindBy(id = "dwfrm_profile_address_postal")
    private PageElement postCodeInput;
    @FindBy(id = "dwfrm_profile_address_phone")
    private PageElement phoneInput;
    @FindBy(name = "dwfrm_profile_address_create")
    private PageElement applyButton;


    public void completeAddressForm(UserDetails details) {
        selectCountry(details.getCountry());
        enterAddressName(details.getAddressName());
        enterFirstName(details.getFirstName());
        enterLastName(details.getLastName());
        enterAddress(details.getAddress1());
        enterCity(details.getCity());
        enterPostCode(details.getPostalCode());
        enterPhoneNumber(details.getPhone());
    }

    public void selectCountry(String country) {
        countryDropDown.waitUntil(displayed.and(enabled)).select().byVisibleTextContains(country);
    }

    public void enterAddressName(String addressName){
        addressNameInput.typeText(addressName);
    }

    public void enterFirstName(String fName) {
        firstNameInput.typeText(fName);
    }

    public void enterLastName(String lName) {
        lastNameInput.typeText(lName);
    }

    public void enterAddress(String address) {
        address1Input.typeText(address);
    }

    public void enterCity(String city) {
        cityInput.typeText(city);
    }

    public void enterPostCode(String postCode) {
        postCodeInput.typeText(postCode);
    }

    public void enterPhoneNumber(String number) {
        phoneInput.typeText(number);
    }

    public void clickApply() {
        applyButton.waitUntil(displayed.and(enabled)).click();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
    }

}
