package com.thorntons.missions;

import com.thorntons.context.ThorntonsContext;
import com.thorntons.pages.components.HeaderComponent;
import com.thorntons.pages.ProductDetailsPage;

import javax.inject.Inject;

public class ShoppingMission {

    final HeaderComponent headerComponent;
    final ProductDetailsPage productDetailsPage;
    final ThorntonsContext context;

    @Inject
    public ShoppingMission(final ThorntonsContext context, final HeaderComponent headerComponent, final ProductDetailsPage productDetailsPage){
        this.context = context;
        this.headerComponent = headerComponent;
        this.productDetailsPage = productDetailsPage;
    }

    public void Search(String searchTerm){
        headerComponent
                .clickSearchIcon()
                .inputSearchTerm(searchTerm)
                .submitSearch();
    }

    public void addToBasket() {
        context.setProduct(productDetailsPage.getProductDetails());
        productDetailsPage.clickAddToBag();
        productDetailsPage.dialogAddPersonalMessage("no");
    }
}
