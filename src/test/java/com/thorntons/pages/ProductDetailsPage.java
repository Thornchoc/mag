package com.thorntons.pages;

import com.thorntons.Product;
import com.thorntons.context.ThorntonsContext;
import io.magentys.cinnamon.conf.Env;
import io.magentys.cinnamon.webdriver.collections.PageElementCollection;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import io.magentys.cinnamon.webdriver.support.FindByKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import javax.inject.Inject;


public class ProductDetailsPage {

    @FindByKey("single-product-page.add-to-cart")
    private PageElement addToBag;
    @FindByKey("single-product-page.view-cart")
    private PageElement viewBag;
    @FindBy(css = ".product-name")
    private PageElement productName;
    @FindBy(css = ".price-sales")
    private PageElement price;
    @FindBy(id = "Quantity")
    private PageElement quantityInput;
    

    public void addtoBag() {
        addToBag.click();
    }

    public void viewCart()  { viewBag.click(); }

    public Product getProductDetails() {
        return new Product(productName.getText(), price.getText(), quantityInput.getText());
    }

}
