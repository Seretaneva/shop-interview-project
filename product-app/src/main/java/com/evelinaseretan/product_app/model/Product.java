package com.evelinaseretan.product_app.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private String description;
    private String sellerName;
    private float price;
    private int quantity;
}
