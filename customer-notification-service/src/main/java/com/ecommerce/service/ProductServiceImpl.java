package com.ecommerce.service;

import com.ecommerce.exception.DuplicateResourceException;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductById(Long productId) throws ResourceNotFoundException {
        return productRepository.getById(productId);
    }

    @Override
    public Product getProductByName(String productName) throws ResourceNotFoundException {
        return productRepository.getProductByName(productName);
    }

    @Override
    public List<Product> getAllProducts() throws ResourceNotFoundException {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) throws DuplicateResourceException {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product product) throws ResourceNotFoundException{
        return null;
    }


    @Override
    public void deleteProductById(Long productId) throws ResourceNotFoundException{

    }
}
