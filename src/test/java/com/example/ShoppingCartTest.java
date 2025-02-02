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

        Product product = new Product("Singoalla", 28);

        shoppingCart.addProduct(product, 2);

        assertThat(shoppingCart.getTotalPrice()).isEqualTo(56);
    }

}
