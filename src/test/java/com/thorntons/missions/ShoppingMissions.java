package com.thorntons.missions;

import com.thorntons.context.ScenarioContext;
import com.thorntons.pages.components.HeaderComponent;
import com.thorntons.pages.ProductDetailsPage;

import javax.inject.Inject;

public class ShoppingMissions {

    final HeaderComponent headerComponent;
    final ProductDetailsPage productDetailsPage;
    final ScenarioContext context;

    @Inject
    public ShoppingMissions(final ScenarioContext context, final HeaderComponent headerComponent, final ProductDetailsPage productDetailsPage){
        this.context = context;
        this.headerComponent = headerComponent;
        this.productDetailsPage = productDetailsPage;
    }

    public void search(String searchTerm){
        headerComponent
                .clickSearchIcon()
                .inputSearchTerm(searchTerm);
    }

    public void searchAndSubmit(String searchTerm){
        search(searchTerm);
        headerComponent.submitSearch();
    }

    public void searchAndSelect(String searchTerm){
        search(searchTerm);
        headerComponent.selectProductSuggestion(searchTerm);
    }

    public void addToBasket() {
        context.setProduct(productDetailsPage.getProductDetails());
        productDetailsPage.clickAddToBag();
        //productDetailsPage.dialogAddPersonalMessage("no");
    }
}
