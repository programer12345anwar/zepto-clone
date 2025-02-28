package com.db.zepto.db_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String productName;
    int productPrice;
    String details;
    String manufacturerEmail;
    Double rating;
    int weight;
    int totalPurchase;
}
