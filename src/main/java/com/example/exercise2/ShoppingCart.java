package com.example.exercise2;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private final Map<Product, Integer> products = new HashMap<>();
    private int totalPrice = 0;

    public void addProduct(Product product, int quantity) {
        products.put(product, products.getOrDefault(product, 0) + quantity);
        totalPrice += (int) (product.getPrice() * quantity);
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}

