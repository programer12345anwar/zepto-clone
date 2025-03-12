package com.central.zepto.central_api.util;

import com.central.zepto.central_api.model.AppUser;
import com.central.zepto.central_api.requestdto.RegisterUserDTO;

import org.springframework.stereotype.Component;

@Component
public class Adapter {
    public AppUser mapUserRequestBodyToAppUser(RegisterUserDTO user){
        AppUser appUser=AppUser.builder()
                .name(user.getName())
                .email(user.getEmail())
                .address(user.getAddress())
                .pincode(user.getPincode())
                .status("ACTIVE")
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .build();
        return appUser;
    }
}
