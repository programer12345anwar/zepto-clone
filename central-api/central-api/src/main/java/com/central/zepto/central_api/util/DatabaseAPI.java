package com.central.zepto.central_api.util;

import com.central.zepto.central_api.model.AppUser;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;

public class DatabaseAPI {
    String dbApiUrl="/api/v1/db";
    public void callCreateUserEndpoint(AppUser user){
        String url="http://localhost:8081"+dbApiUrl+"user/save";
        URI finalUrl=URI.create(url);
        //create request entity
        RequestEntity request=RequestEntity.post(finalUrl).body(user);
        //create rest template
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AppUser> response=restTemplate.exchange(url, HttpMethod.POST,request,AppUser.class);
    }
}
