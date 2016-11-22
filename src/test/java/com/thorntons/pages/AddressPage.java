package com.thorntons.pages;

import io.magentys.cinnamon.webdriver.collections.PageElementCollection;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.textContains;

public class AddressPage {

    @FindBy(css = ".section-header-note.address-create.button")
    private PageElement createAddressButton;
    @FindBy(css = ".mini-address-title")
    private PageElementCollection addressTitle;

    public void clickCreateNewAddressButton(){
        createAddressButton.waitUntil(displayed.and(enabled)).click();
    }

    public boolean isAddressListed(String addressName){
        return addressTitle.first(textContains(addressName)).isDisplayed();
    }
}
