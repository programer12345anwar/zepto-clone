package com.central.zepto.central_api.requestdto;

import com.central.zepto.central_api.enums.UserType;

public class RegisterUserDTO {
    String name;
    String email;
    String password;
    Long phoneNumber;
    UserType userType;
    int pincode;
}
