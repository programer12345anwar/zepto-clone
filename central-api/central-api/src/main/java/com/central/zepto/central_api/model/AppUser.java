package com.central.zepto.central_api.model;

import lombok.Data;

import java.util.UUID;

@Data
public class AppUser {
    UUID id;
    String name;
    String email;
    String password;
    Long phoneNumber;
    String userType;
    int pincode;
    String status;
}
