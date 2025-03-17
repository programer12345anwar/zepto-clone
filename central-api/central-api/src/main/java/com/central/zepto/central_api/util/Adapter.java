package com.central.zepto.central_api.util;

import com.central.zepto.central_api.model.AppUser;
import com.central.zepto.central_api.requestdto.RegisterUserDTO;

import org.springframework.stereotype.Component;

@Component //it will create a new instance of this class
public class Adapter {
    public AppUser mapUserRequestBodyToAppUser(RegisterUserDTO user){
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
}
