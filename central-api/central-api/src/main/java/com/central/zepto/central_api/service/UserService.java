package com.central.zepto.central_api.service;

import com.central.zepto.central_api.model.AppUser;
import com.central.zepto.central_api.requestdto.RegisterUserDTO;
import com.central.zepto.central_api.util.DatabaseAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private DatabaseAPI databaseAPI;//it will communicate with database api to store the data
    public AppUser createUser(RegisterUserDTO user) {
        databaseAPI.callCreateUserEndpoint(user); // Calls the Database API to create a new user
        return null;
    }
}
