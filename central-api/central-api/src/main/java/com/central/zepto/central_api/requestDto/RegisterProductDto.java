package com.central.zepto.central_api.requestDto;

import lombok.Data;

@Data
public class RegisterProductDto {
    String productName;
    int productPrice;
    String details;
    String manufacturerEmail;
    Double rating;
    int weight;
    int totalPurchase;
}