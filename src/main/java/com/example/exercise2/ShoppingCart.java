package com.example.exercise2;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private final Map<Product, Integer> products = new HashMap<>();
    private int totalPrice = 0;

    public void addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Product cannot be null and quantity must be positive.");
        }

        products.put(product, products.getOrDefault(product, 0) + quantity);
        totalPrice += (int) (product.getPrice() * quantity);
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void removeProduct(Product product, int quantity) {

        int currentQuantity = products.getOrDefault(product, 0);
        if (currentQuantity > quantity) {
            products.put(product, currentQuantity - quantity);
        } else {
            products.remove(product);
        }

        totalPrice -= (int) (product.getPrice() * quantity);
    }

}

