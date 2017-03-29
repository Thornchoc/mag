package com.thorntons.context;

import java.util.ArrayList;
import java.util.List;

import com.thorntons.model.Product;
import com.thorntons.model.UserDetails;

public class ScenarioContext {

    private UserDetails userDetails;
    List<Product> products = new ArrayList<>();
    private Product product;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }
}