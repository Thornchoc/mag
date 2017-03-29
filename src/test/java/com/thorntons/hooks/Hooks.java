package com.thorntons.hooks;

import static io.magentys.cinnamon.webdriver.Browser.open;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import io.magentys.cinnamon.conf.Env;
import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.ReadyState;
import io.magentys.cinnamon.webdriver.conditions.Conditions;

import javax.inject.Inject;

import org.openqa.selenium.WebDriver;

import com.thorntons.pages.HomePage;
import com.thorntons.pages.components.CookieBanner;

import cucumber.api.java.Before;

public class Hooks {

    private final Env env;
    private final HomePage homePage;
    private final WebDriver webDriver;
    private final CookieBanner cookieBanner;

    @Inject
    public Hooks(final Env env, final HomePage homePage, final WebDriver webDriver, final CookieBanner cookieBanner) {
        this.env = env;
        this.homePage = homePage;
        this.webDriver = webDriver;
        this.cookieBanner = cookieBanner;
    }

    // The website URL is automatically navigated to before each scenario tagged with @web
    @Before("@thorntons")
    public void openWebSite() throws Throwable {
        open(env.config.getString("thorntons-url"));
        maximiseHack();
        assertThat("Cannot open the website", homePage.topBanner.waitUntil(displayed).isPresent(), equalTo(true));
        cookieBanner.close();
    }

    public void maximiseHack(){
        webDriver.manage().window().maximize();
        Browser.refresh();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
    }
}