package com.ecommerce.service;

import com.ecommerce.exception.DuplicateResourceException;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long productId) throws ResourceNotFoundException;

    Product getProductByName(String productName) throws ResourceNotFoundException;

    List<Product> getAllProducts() throws ResourceNotFoundException;

    Product saveProduct(Product product) throws DuplicateResourceException;

    Product updateProduct(Long productId, Product product) throws ResourceNotFoundException;

    void deleteProductById(Long productId) throws ResourceNotFoundException;
}
