package com.central.zepto.central_api.service;

import com.central.zepto.central_api.requestdto.RegisterUserDTO;
import com.central.zepto.central_api.util.DatabaseAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private DatabaseAPI databaseAPI;
    public void createUser(RegisterUserDTO user) {

    }
}
