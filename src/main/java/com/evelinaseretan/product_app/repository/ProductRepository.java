package com.evelinaseretan.product_app.repository;
import com.evelinaseretan.product_app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository
        extends JpaRepository <Product , Integer> {
}
