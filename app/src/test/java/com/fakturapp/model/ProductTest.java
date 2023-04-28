package com.fakturapp.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class ProductTest {

    List<Product> products;

    @BeforeEach
    void setUp() {
        products = new ArrayList<>();
    }

    @Test
    void calculateProductsTotalPrice() {
        Product product1 = new Product("name1", "1", "1");
        Product product2 = new Product("name2", "1", "1");
        Product product3 = new Product("name3", "1", "1");
        products.add(product1);
        products.add(product2);
        products.add(product3);

        assertEquals(new BigDecimal("3"), Product.calculateProductsTotalPrice(products));
    }

    @Test
    void calculateProductsTotalPriceDecimal() {
        Product product1 = new Product("name1", "1", "1.1");
        Product product2 = new Product("name2", "1", "1.1");
        Product product3 = new Product("name3", "1", "1.1");
        products.add(product1);
        products.add(product2);
        products.add(product3);

        assertEquals(new BigDecimal("3.3"), Product.calculateProductsTotalPrice(products));
    }

    @Test
    void calculateProductsTotalPriceEmpty() {
        assertEquals(BigDecimal.ZERO, Product.calculateProductsTotalPrice(products));
    }

}