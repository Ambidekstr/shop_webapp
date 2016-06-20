package com.ambidekstr.shop.model;

import org.springframework.stereotype.Component;

/**
 * Created by Ambidekstr on 19-Jun-16.
 */
@Component

public class Product {
    private int productId;
    private String product;
    private double price;

    public Product() {
    }

    public Product(int productId, String product, double price) {
        this.productId = productId;
        this.product = product;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
