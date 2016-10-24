package com.thorntons.context;

import com.thorntons.Product;

import java.util.ArrayList;
import java.util.List;

public class ThorntonsContext {

    List<Product> products = new ArrayList<>();
    
    
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
