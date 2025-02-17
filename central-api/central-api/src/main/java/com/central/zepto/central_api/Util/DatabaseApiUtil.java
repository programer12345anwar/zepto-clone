package com.central.zepto.central_api.Util;

import com.central.zepto.central_api.models.AppUser;
import com.central.zepto.central_api.models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class DatabaseApiUtil extends ApiUtilImpl {

    @Value("${db.api.url}")
    String dbApiUrl;

    @Autowired
    ModelMapper mapper;

    public AppUser callCreateUserEndpoint(AppUser user){
        //creation of url
//        String url = "http://localhost:8081" + dbApiUrl + "/user/save";
//        URI finalUrl = URI.create(url);
//        //create request entity
//        RequestEntity request = RequestEntity.post(finalUrl).body(user);
//        // Create rest Template
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<AppUser> response =restTemplate.exchange(url, HttpMethod.POST, request, AppUser.class);
//        return response.getBody();

        Object resp = makePostCall(dbApiUrl, "/user/save", new HashMap<>(), user);
        AppUser userResp = mapper.map(resp, AppUser.class);
        return userResp;
    }

    public Product callCreateProductEndPoint(Product product){
        Object resp = makePostCall(dbApiUrl, "/product/save", new HashMap<>(), product);
        return mapper.map(resp, Product.class);

    }

    public AppUser getUserByEmail(String email){
        String endPoint =  "/user/email/" + email;
        Object resp  = makeGetCall(dbApiUrl, endPoint, new HashMap<>());
        return mapper.map(resp, AppUser.class);
    }
}
