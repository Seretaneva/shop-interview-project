package com.evelinaseretan.product_app.service;

import com.evelinaseretan.product_app.model.Product;
import com.evelinaseretan.product_app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
            return productRepository.findAll();
    }

    public List<Product> getProductsByName(String name){
        return productRepository.getProductsByName(name);
    }
}
