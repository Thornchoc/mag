package com.thorntons.hooks;

import javax.inject.Inject;

import com.thorntons.pages.HomePage;
import io.magentys.cinnamon.conf.Env;
import cucumber.api.java.Before;
import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.ReadyState;
import io.magentys.cinnamon.webdriver.conditions.Conditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.html5.Utils;

import static io.magentys.cinnamon.webdriver.Browser.open;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class Hooks {

    private final Env env;
    private final HomePage homePage;
    private final WebDriver webDriver;

    @Inject
    public Hooks(final Env env, final HomePage homePage, final WebDriver webDriver) {
        this.env = env;
        this.homePage = homePage;
        this.webDriver = webDriver;
    }

    // The website URL is automatically navigated to before each scenario tagged with @web
    @Before("@thorntons")
    public void openWebSite() throws Throwable {
        open(env.config.getString("thorntons-url"));
        webDriver.manage().window().maximize();
        Browser.waitUntil(Conditions.readyState(ReadyState.COMPLETE));
        assertThat("Cannot open the website", homePage.topBanner.waitUntil(displayed).isPresent(), equalTo(true));
    }
}