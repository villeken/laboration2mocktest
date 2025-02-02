package com.example;

import com.example.exercise2.Product;
import com.example.exercise2.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @BeforeEach
    void setup() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    void shouldAddProductToShoppingCart() {

        Product product = new Product("Singoalla", 30);

        shoppingCart.addProduct(product, 2);

        assertThat(shoppingCart.getTotalPrice()).isEqualTo(60);
    }

    @Test
    void shouldRemoveProductFromShoppingCart() {

        Product product = new Product("Singoalla", 30);

        shoppingCart.addProduct(product, 2);

        shoppingCart.removeProduct(product, 1);

        assertThat(shoppingCart.getTotalPrice()).isEqualTo(30);
    }

    @Test
    void shouldCalculateTotalPrice() {
        Product product1 = new Product("Singoalla", 30);
        Product product2 = new Product("Ballerina", 26);

        shoppingCart.addProduct(product1, 2);
        shoppingCart.addProduct(product2, 1);

        assertThat(shoppingCart.getTotalPrice()).isEqualTo(86);
    }

    @Test
    void ApplyTheCorrectDiscountToTotalPrice() {
        Product product1 = new Product("Singoalla", 30);
        shoppingCart.addProduct(product1, 2);

        shoppingCart.applyDiscount(0.2);

        assertThat(shoppingCart.getTotalPrice()).isEqualTo(48);
    }

}
