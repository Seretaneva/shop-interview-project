package com.evelinaseretan.product_app;

import com.evelinaseretan.product_app.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProductAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);


	}

    @GetMapping
    public String hyMan(){
        return  "Hello Man";
    }
}
