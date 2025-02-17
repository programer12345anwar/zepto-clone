package com.central.zepto.central_api.service;

import com.central.zepto.central_api.Util.Adapter;
import com.central.zepto.central_api.Util.DatabaseApiUtil;
import com.central.zepto.central_api.enums.UserType;
import com.central.zepto.central_api.exception.UnAuthorized;
import com.central.zepto.central_api.exception.UserNotFoundException;
import com.central.zepto.central_api.models.AppUser;
import com.central.zepto.central_api.models.Product;
import com.central.zepto.central_api.requestDto.RegisterProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    Adapter adapter;

    @Autowired
    DatabaseApiUtil databaseApiUtil;


    public Product createProduct(RegisterProductDto product, String userEmail){
        // map registerProductDto to productModel
        Product productObj = adapter.mapRegisterProductDTOToProduct(product);

        AppUser user = databaseApiUtil.getUserByEmail(userEmail);
        if(user == null){
            throw new UserNotFoundException(String.format("User with email %s does not exist", userEmail));
        }
        if(!user.getUserType().equals(UserType.APPLICATION_ADMIN.toString())){
            throw new UnAuthorized(String.format("User with email %s does not have access to create product", userEmail));
        }
        Product productResp = databaseApiUtil.callCreateProductEndPoint(productObj);
        return productResp;
    }
}
