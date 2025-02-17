package com.central.zepto.central_api.Util;

import com.central.zepto.central_api.models.AppUser;
import com.central.zepto.central_api.models.Product;
import com.central.zepto.central_api.requestDto.RegisterProductDto;
import com.central.zepto.central_api.requestDto.RegisterUserDto;
import org.springframework.stereotype.Component;

@Component
public class Adapter {

    public AppUser mapUserRequestBodyToAppUser(RegisterUserDto user){
        AppUser appUser = AppUser.builder()
                .name(user.getName())
                .userType(user.getUserType().toString())
                .email(user.getEmail())
                .address(user.getAddress())
                .pincode(user.getPincode())
                .status("ACTIVE")
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .build();
        return appUser;
    }

    public Product mapRegisterProductDTOToProduct(RegisterProductDto productDTO){
        Product product = Product.builder()
                .productName(productDTO.getProductName())
                .productPrice(productDTO.getProductPrice())
                .details(productDTO.getDetails())
                .weight(productDTO.getWeight())
                .rating(0.0)
                .manufacturerEmail(productDTO.getManufacturerEmail())
                .totalPurchase(0)
                .build();
        return product;
    }

}
