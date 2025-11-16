package com.evelinaseretan.product_app.service;

import com.evelinaseretan.product_app.model.Product;
import com.evelinaseretan.product_app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Product> findByPriceBetween(float minPrice, float maxPrice){
        List<Product> productsBetween = new ArrayList<>();
        for(Product product : productRepository.findAll()){
            if(product.getPrice() > minPrice && product.getPrice() < maxPrice){
                productsBetween.add(product);
            }
        }
        return productsBetween;
    }

    public List<Product> findByHigherPrice(float maxPrice){
        List<Product> productsHighest = new ArrayList<>();
        for(Product product : productRepository.findAll()) {
            if (product.getPrice() < maxPrice) {
                productsHighest.add(product);
            }
        }
        return  productsHighest;
    }

    public List<Product> findByLowerPrice(float minPrice){
        List<Product> productsLower = new ArrayList<>();
        for(Product product : productRepository.findAll()) {
            if (product.getPrice() > minPrice) {
                productsLower.add(product);
            }
        }
        return  productsLower;
    }
}
