package com.thorntons.pages;

import com.thorntons.context.ScenarioContext;
import io.magentys.cinnamon.conf.Env;
import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.collections.PageElementCollection;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import io.magentys.cinnamon.webdriver.support.FindByKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import javax.inject.Inject;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.*;

public class HomePage {

    protected static final String THORNTONS_URL = "thorntons-url";

    protected final ScenarioContext context;
    protected final Env env;
    
    public WebDriver webDriver;

    @FindByKey("home-page.top-banner")
    public PageElement topBanner;
    
    @FindBy(css = "#navigation ul li a")
    private PageElementCollection categoriesAndTypes;
    
    
    @Inject
    public HomePage(final Env env, WebDriver webDriver, final ScenarioContext context) {
        this.env = env;
        this.webDriver=webDriver;
        this.context = context;
    }
    
    public void open() {
        Browser.open(env.config.getString(THORNTONS_URL));
    }
    
    public boolean waitUntilOpened() {
        return topBanner.waitUntil(displayed).isPresent();
    }
    
    public void selectCategory(String category) throws InterruptedException {
        categoriesAndTypes.first(attributeContains("href", "Thorntons/" + category)).hoverOver();
    }

    public void selectType(String type) throws InterruptedException {
        categoriesAndTypes.first(attributeContains("href", "Thorntons/" + type)).click();
    }
}