package com.evelinaseretan.product_app.controller;

import com.evelinaseretan.product_app.dto.ProductDTO;
import com.evelinaseretan.product_app.model.Product;
import com.evelinaseretan.product_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductDTO> getProducts(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) Float minPrice,
                                        @RequestParam(required = false) Float maxPrice) {
        List<Product> products;

        if (name != null) {
            products = productService.getProductsByName(name);
        } else if (minPrice != null && maxPrice == null) {
            products = productService.findByLowerPrice(minPrice);
        } else if (minPrice == null && maxPrice != null) {
            products = productService.findByHigherPrice(maxPrice);
        } else if (minPrice != null && maxPrice != null) {
            products = productService.findByPriceBetween(minPrice, maxPrice);
        } else {
            products = productService.getAllProducts();
        }

        return products.stream()
                .map(ProductDTO::new)
                .toList();
    }

    @PostMapping("/add-product")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
}
