package com.thorntons.pages;

import io.magentys.cinnamon.webdriver.collections.PageElementCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;
import com.thorntons.Product;
import com.thorntons.context.ThorntonsContext;

import io.magentys.cinnamon.conf.Env;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import io.magentys.cinnamon.webdriver.support.FindByKey;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingBagPage {
    
    private List<Product> actualProducts;

    protected final ThorntonsContext context;
    protected final Env env;

    public WebDriver webDriver;

    @FindByKey("bag-page.checkout-button")
    public PageElement checkOut;

    @FindByKey(value = "bag-page.cart-row")
    public PageElementCollection cartRow;

    @Inject
    public ShoppingBagPage(ThorntonsContext context, WebDriver webDriver, Env env) {
        this.context = context;
        this.webDriver=webDriver;
        this.env = env;
    }

    public void checkOut() throws InterruptedException {
        checkOut.click();
        Thread.sleep(5000);
    }

    public void verifyShoppingBag() {
        for(WebElement aCartRow : cartRow.getWrappedElements()) {
            String description = aCartRow.findElement(By.cssSelector(".item-details.name")).getText();
            String price = aCartRow.findElement(By.cssSelector(".item-price")).getText();
            String quantity = aCartRow.findElement(By.cssSelector(".item-quantity input")).getAttribute("value");
            actualProducts.add(new Product(description, price));
        }
    }
    
}
