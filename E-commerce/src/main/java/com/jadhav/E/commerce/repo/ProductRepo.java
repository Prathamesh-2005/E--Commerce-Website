package com.jadhav.E.commerce.repo;

import com.jadhav.E.commerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    // Search products by keyword in name or description
    @Query("SELECT p FROM Product p WHERE " +
            "(:name IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:description IS NULL OR LOWER(p.description) LIKE LOWER(CONCAT('%', :description, '%'))) AND " +
            "(:brand IS NULL OR LOWER(p.brand) LIKE LOWER(CONCAT('%', :brand, '%'))) AND " +
            "(:price IS NULL OR p.price = :price) AND " +
            "(:category IS NULL OR LOWER(p.category) LIKE LOWER(CONCAT('%', :category, '%'))) AND " +
            "(:releaseDate IS NULL OR p.releaseDate = :releaseDate) AND " +
            "(:productAvailable IS NULL OR p.productAvailable = :productAvailable) AND " +
            "(:stockQuantity IS NULL OR p.stockQuantity >= :stockQuantity)")
    List<Product> searchProducts(String keyword);
}
