package com.thorntons.pages;

import com.thorntons.context.ThorntonsContext;

import io.magentys.cinnamon.conf.Env;
import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.actions.Action;
import io.magentys.cinnamon.webdriver.actions.synthetic.SyntheticHoverAction;
import io.magentys.cinnamon.webdriver.collections.PageElementCollection;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import io.magentys.cinnamon.webdriver.support.FindByKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import io.magentys.cinnamon.webdriver.actions.basic.*;

import javax.inject.Inject;

import static io.magentys.cinnamon.webdriver.Browser.fireEvent;
import static io.magentys.cinnamon.webdriver.Browser.switchTo;
import static io.magentys.cinnamon.webdriver.Timeouts.defaultTimeout;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.*;

public class HomePage {

    protected static final String THORNTONS_URL = "thorntons-url";

    protected final ThorntonsContext context;
    protected final Env env;
    
    public WebDriver webDriver;

    @FindByKey("home-page.top-banner")
    public PageElement topBanner;
    
    @FindByKey("home-page.our-shops")
    public PageElement ourShops;
    
    @FindBy(css = "#navigation ul li a")
    private PageElementCollection categoriesAndTypes;
    
    
    @Inject
    public HomePage(final Env env, WebDriver webDriver, final ThorntonsContext context) {
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

    public void selectOurShops() throws InterruptedException {
        ourShops.waitUntil(clickable).hoverOver().byOffset(20, 20).click();
        Thread.sleep(4000);
        ourShops.waitUntil(clickable).hoverOver().byOffset(20, 20).click();  
    }
    
}