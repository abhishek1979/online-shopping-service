
package com.ecommerce.repository;

import com.ecommerce.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        // create product
        product1 = new Product();
        product1.setName("product 1");
        product1.setDescription("product 1 description");
        product1.setSku("100ABC");
        product1.setPrice(new BigDecimal(100));
        product1.setActive(true);
        product1.setImageUrl("product1.png");

        product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("product 2 description");
        product2.setSku("100DEF");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);
        product2.setImageUrl("product2.png");
    }

    @AfterEach
    void tearDown() {
        product1 = null;
        product2 = null;
    }

    @Test
    void saveMethod(){
        // save product
        Product savedObject = productRepository.save(product2);

        // display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject);

    }
}
