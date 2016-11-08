package com.thorntons.pages.components;

import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;

public class CookieBanner {

    @FindBy(css = ".cookie-warning-close")
    private PageElement bannerX;

    public void close(){
        bannerX.waitUntil(displayed.and(enabled)).click();
    }
}
