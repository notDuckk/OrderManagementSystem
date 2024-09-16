package org.example.ordermanagementsystem.service;

import org.example.ordermanagementsystem.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testSaveProduct() {
        Product product = new Product();
        product.setName("Sample Product");
        product.setPrice(99.99);

        Product savedProduct = productService.saveProduct(product);
        assertNotNull(savedProduct);
        assertEquals(product.getName(), savedProduct.getName());
        assertEquals(product.getPrice(), savedProduct.getPrice());
    }

    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setName("Sample Product");
        product.setPrice(99.99);
        Product savedProduct = productService.saveProduct(product);

        Product foundProduct = productService.getProductById(savedProduct.getId());
        assertNotNull(foundProduct);
        assertEquals(savedProduct.getId(), foundProduct.getId());
    }

    @Test
    public void testDeleteProductById() {
        Product product = new Product();
        product.setName("Sample Product");
        product.setPrice(99.99);
        Product savedProduct = productService.saveProduct(product);

        productService.deleteProduct(savedProduct.getId());

        assertThrows(Exception.class, () -> {
            productService.getProductById(savedProduct.getId());
        });
    }
}