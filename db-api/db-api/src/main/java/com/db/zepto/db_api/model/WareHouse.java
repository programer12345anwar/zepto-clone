package com.db.zepto.db_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class WareHouse {
    @Id
    @GeneratedValue()
    UUID id;
    String name;
    String address;
    @Column(unique = true, nullable = false)
    String email;
    int pincode;
    @OneToOne
    AppUser manager;
}
