package com.central.zepto.central_api.requestDto;

import com.central.zepto.central_api.enums.UserType;
import lombok.Data;

@Data
public class RegisterUserDto {
    String name;
    String email;
    String password;
    Long phoneNumber;
    int pincode;
    String address;
    UserType userType;

    @Data
    public static class RegisterProductDTO {
        String productName;
        int productPrice;
        String details;
        String manufacturerEmail;
        int weight;
        int totalPurchase;
    }
}
