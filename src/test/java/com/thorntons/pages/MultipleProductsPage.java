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

import java.util.List;

public class MultipleProductsPage {

    protected final ThorntonsContext context;
    protected final Env env;

    public WebDriver webDriver;

    @FindBy(css = ".search-result-options .pagination ul li")
    private PageElementCollection pages;

    @Inject
    public MultipleProductsPage(final Env env, WebDriver webDriver, final ThorntonsContext context) {
        this.env = env;
        this.webDriver=webDriver;
        this.context = context;
    }
    

    public void selectProductByName(String name) throws InterruptedException {
        
        boolean productFound = false;
        
        // first find the product on one of the 1 - x product pages
        for(int i = 0; i < pages.size(); i++) {
            
            if (productFound) break;
            else 
                if (i != 0 && i < pages.size() -1) {
                    pages.getWrappedElements().get(i).findElement(By.cssSelector("a")).click();
                    Thread.sleep(2000); //Replace with something better!
                }
            

            List<WebElement> productTiles = webDriver.findElements(By.cssSelector("#search-result-items li.grid-tile"));
            for(int j = 0; j < productTiles.size(); j++) {
                
                if(productTiles.get(j).getText().contains(name)) {
                    // add details of product to context
                    //WebElement productPricing = webDriver.findElement(By.xpath("//a[contains(@title,'" + name + "')]/../following-sibling::div[@class='product-pricing']"));
                    WebElement productPricing =
                            productTiles.get(j).findElement(By.xpath("//a[contains(@title,'" + name + "')]/../following-sibling::div[@class='product-pricing']"));
                    String price = productPricing.getText();
                    Product product = new Product(name, price, "1");
                    product.setName(name);
                    product.setPrice(price);
                    context.addProduct(product);

                    productTiles.get(j).findElement(By.xpath("//a[contains(@title,'" + name + "')]")).click();

                    productFound = true;
                    break;
                }
            }
        }
    }
}
