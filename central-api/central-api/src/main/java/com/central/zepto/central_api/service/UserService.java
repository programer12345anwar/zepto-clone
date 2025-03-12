package com.central.zepto.central_api.service;

import com.central.zepto.central_api.model.AppUser;
import com.central.zepto.central_api.requestdto.RegisterUserDTO;
import com.central.zepto.central_api.util.Adapter;
import com.central.zepto.central_api.util.DatabaseAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private DatabaseAPI databaseAPI;//it will communicate with database api to store the data

    @Autowired
    private Adapter adapter;
    public AppUser createUser(RegisterUserDTO user) {
        AppUser appUser=adapter.mapUserRequestBodyToAppUser(user);
        AppUser response=databaseAPI.callCreateUserEndpoint(appUser); // Calls the Database API to create a new user
        return response;
    }
}
