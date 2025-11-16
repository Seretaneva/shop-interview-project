package com.evelinaseretan.product_app.dto;

import com.evelinaseretan.product_app.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private String sellerName;
    private float price;
    private int quantity;
    private Integer categoryId;
    private String categoryName;
    private Integer subCategoryId;
    private String subCategoryName;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.sellerName = product.getSellerName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();

        if (product.getSubCategory() != null) {
            this.subCategoryId = product.getSubCategory().getId();
            this.subCategoryName = product.getSubCategory().getName();

            if (product.getSubCategory().getCategory() != null) {
                this.categoryId = product.getSubCategory().getCategory().getId();
                this.categoryName = product.getSubCategory().getCategory().getName();
            }
        }
    }
}
