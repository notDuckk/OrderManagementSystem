package org.example.ordermanagementsystem.repos;

import org.example.ordermanagementsystem.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
