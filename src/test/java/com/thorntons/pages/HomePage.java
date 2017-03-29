package com.thorntons.pages;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.attributeContains;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import io.magentys.cinnamon.conf.Env;
import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.collections.PageElementCollection;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import io.magentys.cinnamon.webdriver.support.FindByKey;

import javax.inject.Inject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.thorntons.context.ScenarioContext;

public class HomePage {

    protected static final String THORNTONS_URL = "thorntons-url";

    private static final String THORNTONS_ENV = "thorntons-env";

    protected final ScenarioContext context;
    protected final Env env;

    public WebDriver webDriver;

    @FindByKey("home-page.top-banner")
    public PageElement topBanner;

    @FindByKey("home-page.our-shops")
    public PageElement ourShops;

    @FindBy(css = "#navigation ul li a")
    private PageElementCollection categoriesAndTypes;

    @Inject
    public HomePage(final Env env, WebDriver webDriver,
            final ScenarioContext context) {
        this.env = env;
        this.webDriver = webDriver;
        this.context = context;
    }

    public void open() {
        Browser.open(env.config.getString(THORNTONS_URL));
    }

    public boolean waitUntilOpened() {
        return topBanner.waitUntil(displayed).isPresent();
    }

    public void selectCategory(String category) throws InterruptedException {
        categoriesAndTypes.first(
                attributeContains("href", "Thorntons/" + category)).hoverOver();
    }

    public void selectType(String type) throws InterruptedException {
        categoriesAndTypes
                .first(attributeContains("href", "Thorntons/" + type)).click();
    }

    public void selectOurShops() throws InterruptedException {
        // NOTE: Clicking on the Our Shops doesn't work at the moment. Go to URL
        // directly instead
        // ourShops.waitUntil(clickable).hoverOver().byOffset(0, 0).click();
        Browser.open("https://" + env.config.getString(THORNTONS_ENV)
                + "-store-thorntons.demandware.net/s/Thorntons/store-locator/");
    }

}