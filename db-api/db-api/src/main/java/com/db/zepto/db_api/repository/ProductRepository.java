package com.db.zepto.db_api.repository;

import com.db.zepto.db_api.model.AppUser;
import com.db.zepto.db_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
