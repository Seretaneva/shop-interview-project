package com.evelinaseretan.product_app.controller;

import com.evelinaseretan.product_app.model.Product;
import com.evelinaseretan.product_app.repository.ProductRepository;
import com.evelinaseretan.product_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts()  {
        return productService.getAllProducts();
    }

    @PostMapping("/add-product")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }
}
