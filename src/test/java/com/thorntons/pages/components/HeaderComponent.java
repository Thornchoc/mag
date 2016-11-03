package com.thorntons.pages.components;

import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.ReadyState;
import io.magentys.cinnamon.webdriver.conditions.Conditions;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.Conditions.ajaxFinished;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.textContains;

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

    public HeaderComponent clickSearchIcon(){
        searchIcon.waitUntil(enabled).click();
        return this;
    }

    public HeaderComponent inputSearchTerm(String searchTerm){
        searchInput.waitUntil(enabled.and(displayed)).typeText(searchTerm);
        Browser.waitUntil(ajaxFinished);
        return this;
    }

    public HeaderComponent submitSearch(){
        searchSubmitBtn.waitUntil(displayed.and(enabled)).click();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
        return this;
    }

    public void selectProductSuggestion(String product){
        productSuggestion.waitUntil(textContains(product).and(displayed)).click();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
    }

    public void hoverOverCartIcon(){
        basketIcon.hoverOver();
    }

}
