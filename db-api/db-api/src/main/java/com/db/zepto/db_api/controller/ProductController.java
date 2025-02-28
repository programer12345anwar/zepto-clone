package com.db.zepto.db_api.controller;

import com.db.zepto.db_api.model.Product;
import com.db.zepto.db_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/product")
public class ProductController {
    // Define product-related endpoints here
    private ProductRepository productRepository;
    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product) {
        productRepository.save(product);
        return product;
    }

    @GetMapping("/{pid}")
    public Product getProductById(@PathVariable UUID pid) {
        return productRepository.findById(pid).orElse(null);
    }
}
