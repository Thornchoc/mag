package com.thorntons.pages;

import com.thorntons.context.ThorntonsContext;
import io.magentys.cinnamon.conf.Env;
import io.magentys.cinnamon.webdriver.collections.PageElementCollection;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import io.magentys.cinnamon.webdriver.support.FindByKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import javax.inject.Inject;


public class SingleProductPage {

    protected final ThorntonsContext context;
    protected final Env env;

    public WebDriver webDriver;


    @FindByKey("home-page.add-to-cart")
    public PageElement addToBag;

    @FindByKey("home-page.view-cart")
    public PageElement viewBag;
    

    @Inject
    public SingleProductPage(final Env env, WebDriver webDriver, final ThorntonsContext context) {
        this.env = env;
        this.webDriver=webDriver;
        this.context = context;
    }

    public void addtoBag() {
        addToBag.click();
    }

    public void viewCart()  { viewBag.click(); }
}
