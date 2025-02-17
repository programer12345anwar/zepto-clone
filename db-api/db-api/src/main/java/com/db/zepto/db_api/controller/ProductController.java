package com.db.zepto.db_api.controller;

import com.db.zepto.db_api.model.Product;
import com.db.zepto.db_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/db/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/save")
    public Product createProduct(@RequestBody Product product){
        productRepository.save(product);
        return product;
    }
}
