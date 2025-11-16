package com.evelinaseretan.product_app.controller;

import com.evelinaseretan.product_app.model.SubCategory;
import com.evelinaseretan.product_app.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcategories")
@CrossOrigin(origins = "http://localhost:3000")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping
    public List<SubCategory> getAllSubCategories() {
        return subCategoryService.getAllSubCategories();
    }

    @GetMapping("/by-category/{categoryId}")
    public List<SubCategory> getSubCategoriesByCategory(@PathVariable Integer categoryId) {
        return subCategoryService.getSubCategoriesByCategoryId(categoryId);
    }

    @PostMapping
    public SubCategory addSubCategory(@RequestBody SubCategory subCategory) {
        return subCategoryService.addSubCategory(subCategory);
    }
}
