package com.evelinaseretan.product_app.controller;

import com.evelinaseretan.product_app.model.Product;
import com.evelinaseretan.product_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts (@RequestParam(required = false) String name, @RequestParam(required = false) Float minPrice, @RequestParam(required = false) Float maxPrice) {
        if (name != null) {
            return productService.getProductsByName(name);
        }
        if (minPrice != null && maxPrice == null){
            return productService.findByLowerPrice(minPrice);
        }
        if ( minPrice == null && maxPrice != null){
            return productService.findByHigherPrice(maxPrice);
        }
        if (minPrice != null ){
            return  productService.findByPriceBetween(minPrice,maxPrice);
        }
        return productService.getAllProducts();

    }

    @PostMapping("/add-product")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }


}
