package com.evelinaseretan.product_app.service;

import com.evelinaseretan.product_app.model.Category;
import com.evelinaseretan.product_app.model.SubCategory;
import com.evelinaseretan.product_app.repository.CategoryRepository;
import com.evelinaseretan.product_app.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private  CategoryRepository categoryRepository;
    @Autowired
    private  SubCategoryRepository subCategoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category electronics = new Category();
        electronics.setName("Electronics");
        categoryRepository.save(electronics);

        Category clothing = new Category();
        clothing.setName("Clothing");
        categoryRepository.save(clothing);

        SubCategory phones = new SubCategory();
        phones.setName("Phones");
        phones.setCategory(electronics);
        subCategoryRepository.save(phones);

        SubCategory laptops = new SubCategory();
        laptops.setName("Laptops");
        laptops.setCategory(electronics);
        subCategoryRepository.save(laptops);

        SubCategory mensWear = new SubCategory();
        mensWear.setName("Men's Wear");
        mensWear.setCategory(clothing);
        subCategoryRepository.save(mensWear);

        SubCategory womensWear = new SubCategory();
        womensWear.setName("Women's Wear");
        womensWear.setCategory(clothing);
        subCategoryRepository.save(womensWear);
    }
}
