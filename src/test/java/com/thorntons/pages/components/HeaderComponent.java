package com.thorntons.pages.components;

import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.ReadyState;
import io.magentys.cinnamon.webdriver.collections.PageElementCollection;
import io.magentys.cinnamon.webdriver.conditions.Conditions;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.Conditions.ajaxFinished;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.*;

public class HeaderComponent {

    @FindBy(css = ".search.search-icon")
    private PageElement searchIcon;
    @FindBy(id = "q")
    private PageElement searchInput;
    @FindBy(css = ".btn-search")
    private PageElement searchSubmitBtn;
    @FindBy(css = ".basket-icon")
    private PageElement basketIcon;
    @FindBy(css=".product-link")
    private PageElement productSuggestion;
    @FindBy(css = ".user-icon")
    private PageElement myAccountIcon;
    @FindBy(css = ".user-option")
    private PageElementCollection userOptions;
    @FindBy(css = ".user-logout")
    private PageElement signOutButton;

    public HeaderComponent clickMyAccountIcon(){
        myAccountIcon.click();
        return this;
    }

    public HeaderComponent clickRegisterUserOption(){
        clickUserOption("Register");
        return this;
    }

    public HeaderComponent clickLoginOption() {
        clickUserOption("Login");
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
        return this;
    }

    private HeaderComponent clickUserOption(String userOption){
        userOptions.first(textContains(userOption).and(displayed).and(enabled)).click();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
        return this;
    }

    public HeaderComponent clickSearchIcon(){
        searchIcon.waitUntil(enabled).click();
        return this;
    }

    public HeaderComponent inputSearchTerm(String searchTerm){
        searchInput.waitUntil(enabled.and(displayed)).click();
        for(char c : searchTerm.toCharArray()){
            searchInput.typeText(Character.toString(c));
        }
        Browser.waitUntil(ajaxFinished);
        return this;
    }

    public HeaderComponent submitSearch(){
        searchSubmitBtn.waitUntil(displayed.and(enabled)).click();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
        return this;
    }

    public HeaderComponent selectProductSuggestion(String product){
        productSuggestion.waitUntil(displayed.and(enabled).and(textContainsIgnoreCase(product))).click();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
        return this;
    }

    public HeaderComponent hoverOverCartIcon(){
        basketIcon.hoverOver();
        return this;
    }

    public HeaderComponent clickSignOutButton() {
        signOutButton.waitUntil(displayed.and(enabled)).click();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
        return this;
    }
}
