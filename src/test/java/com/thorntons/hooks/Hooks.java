package com.thorntons.hooks;

import javax.inject.Inject;

import com.thorntons.pages.HomePage;
import io.magentys.cinnamon.conf.Env;
import cucumber.api.java.Before;

import static io.magentys.cinnamon.webdriver.Browser.open;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class Hooks {

    private final Env env;
    private final HomePage homePage;

    @Inject
    public Hooks(final Env env, final HomePage homePage) {
        this.env = env;
        this.homePage = homePage;
    }

    // The website URL is automatically navigated to before each scenario tagged with @web
    @Before("@web")
    public void openWebSite() throws Throwable {
        open(env.config.getString("thorntons-url"));
        assertThat("Cannot open the website", homePage.topBanner.waitUntil(displayed).isPresent(), equalTo(true));
    }
}