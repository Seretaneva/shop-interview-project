package com.evelinaseretan.product_app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name="sub_category_id")
    @JsonBackReference
    private SubCategory subCategory;

    private String sellerName;
    private float price;
    private int quantity;
}
