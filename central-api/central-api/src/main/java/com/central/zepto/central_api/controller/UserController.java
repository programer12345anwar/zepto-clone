package com.central.zepto.central_api.controller;

import com.central.zepto.central_api.models.AppUser;
import com.central.zepto.central_api.requestDto.RegisterUserDto;
import com.central.zepto.central_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/central/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public AppUser createUser(@RequestBody RegisterUserDto user){
        AppUser response  = userService.createUser(user);
        return  response;
    }

}
