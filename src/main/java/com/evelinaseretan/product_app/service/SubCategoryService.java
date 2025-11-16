package com.evelinaseretan.product_app.service;

import com.evelinaseretan.product_app.model.SubCategory;
import com.evelinaseretan.product_app.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    public List<SubCategory> getSubCategoriesByCategoryId(Integer categoryId) {
        return subCategoryRepository.findByCategoryId(categoryId);
    }

    public SubCategory addSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }
}
