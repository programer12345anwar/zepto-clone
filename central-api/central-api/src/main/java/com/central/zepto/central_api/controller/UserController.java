package com.central.zepto.central_api.controller;

import com.central.zepto.central_api.model.AppUser;
import com.central.zepto.central_api.requestdto.RegisterUserDTO;
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
    //in central api we don't have repository layer,we will directly communicate with the service layer and service layer will communicate with th db api's repository layer
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/register")
    public AppUser createUser(@RequestBody RegisterUserDTO user){
        //call service layer to save the user
        AppUser response=userService.createUser(user);
        return response;
    }
}
