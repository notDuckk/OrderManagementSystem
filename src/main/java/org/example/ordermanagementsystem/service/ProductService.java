package org.example.ordermanagementsystem.service;

import org.example.ordermanagementsystem.models.Product;
import org.example.ordermanagementsystem.repos.ProductRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).get();
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }


}
