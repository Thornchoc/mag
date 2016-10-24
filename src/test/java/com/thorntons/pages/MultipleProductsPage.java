package com.thorntons.pages;


import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.attributeContains;

import javax.inject.Inject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.thorntons.Product;
import com.thorntons.context.ThorntonsContext;

import io.magentys.cinnamon.conf.Env;
import io.magentys.cinnamon.webdriver.collections.PageElementCollection;

public class MultipleProductsPage {

    protected final ThorntonsContext context;
    protected final Env env;

    public WebDriver webDriver;

    @FindBy(css = "#search-result-items li a")
    private PageElementCollection products;

    @Inject
    public MultipleProductsPage(final Env env, WebDriver webDriver, final ThorntonsContext context) {
        this.env = env;
        this.webDriver=webDriver;
        this.context = context;
    }
    

    public void selectProductByName(String name) throws InterruptedException {
        
        // add details of product to context
        WebElement productPricing = webDriver.findElement(By.xpath("//a[contains(@title,'" + name + "')]/../following-sibling::div[@class='product-pricing']"));
        String price = productPricing.getText();
        Product product = new Product(name, price, "1");
        product.setName(name);
        product.setPrice(price);
        context.addProduct(product);

        products.first(attributeContains("title", name)).click();
    }
}
