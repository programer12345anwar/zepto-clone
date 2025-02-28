package com.db.zepto.db_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class AppOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    LocalDateTime placedTime;
    @ManyToOne //many order can be placed by one customer
    AppUser customer;
    @ManyToOne //many order can be picked up by single delivery partner
    AppUser deliveryPartner;
    int totalAmount;
    @OneToMany //one order can contain multiple products
    List<Product> products;
}
