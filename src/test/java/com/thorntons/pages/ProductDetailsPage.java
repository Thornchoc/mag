package com.thorntons.pages;

import com.thorntons.Product;
import io.magentys.cinnamon.webdriver.collections.PageElementCollection;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import io.magentys.cinnamon.webdriver.support.FindByKey;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.attributeContains;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;


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
    @FindBy(css = ".tag-reminder-btn")
    private PageElementCollection addMessageDialogOptions;
    

    public void clickAddToBag() {
        addToBag.click();
    }

    public void viewCart()  { viewBag.click(); }

    public Product getProductDetails() {
        return new Product(productName.getText(), price.getText(), quantityInput.getText());
    }

    public void dialogAddPersonalMessage(String option) {
        addMessageDialogOptions.first(attributeContains("class", option)).waitUntil(displayed).click();
    }
}
