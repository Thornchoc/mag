package com.thorntons.context;

import com.thorntons.Product;
import com.thorntons.model.UserDetails;

import java.util.ArrayList;
import java.util.List;

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

    public UserDetails getUserDetails(){
        return userDetails;
    }
}
