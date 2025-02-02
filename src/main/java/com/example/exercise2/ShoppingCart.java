package com.example.exercise2;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private final Map<Product, Integer> products = new HashMap<>();
    private int totalPrice = 0;
    private double discount = 0.0;

    public void addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Product cannot be null and quantity must be positive.");
        }

        products.put(product, products.getOrDefault(product, 0) + quantity);
        totalPrice += (int) (product.getPrice() * quantity);
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

    public void applyDiscount(double discount) {
        this.discount = discount;
    }

    public int getTotalPrice() {
        int total = products.entrySet().stream()
                .mapToInt(entry -> (int) (entry.getKey().getPrice() * entry.getValue()))
                .sum();

        return (int) (total * (1 - discount));
    }

}

