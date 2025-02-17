package com.central.zepto.central_api.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class Product {
    UUID id;
    String productName;
    int productPrice;
    String details;
    String manufacturerEmail;
    Double rating;
    int weight;
    int totalPurchase;
}
