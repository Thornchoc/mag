package com.thorntons.pages;

import io.magentys.cinnamon.webdriver.collections.PageElementCollection;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;
import com.thorntons.Product;
import com.thorntons.context.ScenarioContext;

import io.magentys.cinnamon.conf.Env;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import io.magentys.cinnamon.webdriver.support.FindByKey;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBagPage implements ProductView {
    
    private List<Product> actualProducts = new ArrayList<>();
    private ScenarioContext context;

    public ShoppingBagPage(final ScenarioContext context){
        this.context = context;
    }

    @FindByKey("bag-page.checkout-button")
    public PageElement checkOut;

    @FindByKey(value = "bag-page.cart-row")
    public PageElementCollection cartRow;



    public void checkOut() throws InterruptedException {
        checkOut.click();
    }

    public void verifyShoppingBag() {
        setActualProducts();
        List<Product> expectedProducts = context.getProducts();
        Assert.assertTrue(actualProducts.equals(expectedProducts));
    }
    
    public void setActualProducts() {
        for(WebElement aCartRow : cartRow.getWrappedElements()) {
            String description = aCartRow.findElement(By.cssSelector(".item-details .name")).getText();
            String price = aCartRow.findElement(By.cssSelector(".item-price")).getText();
            String quantity = aCartRow.findElement(By.cssSelector(".item-quantity input")).getAttribute("value");
            actualProducts.add(new Product(description, price, "3"));
        }
    }
}
