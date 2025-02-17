package com.central.zepto.central_api.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;

@Component
public class ApiUtilImpl implements ApiUtil{

    @Autowired
    RestTemplate restTemplate;


    public String addQueryParams(String url, HashMap<String, String> queryParams){
        if(queryParams.size() == 0){
            return url;
        }
        url += "?";
        int i = 1;
        for(String key : queryParams.keySet()){
            url += key + "=" + queryParams.get(key);
            if(i < queryParams.size()){
                url += "&";
            }
            i++;
        }
        return url;
    }

    public URI getFinalUrl(String apiUrl, String endPoint, HashMap<String, String> queryParams){
        String url = apiUrl + endPoint;
        url = addQueryParams(url, queryParams);
        URI finalUrl = URI.create(url);
        return finalUrl;
    }

    public Object makeGetCall(String apiUrl, String apiEndpoint, HashMap<String, String> queryParams){
        URI url = this.getFinalUrl(apiUrl, apiEndpoint, queryParams);
        RequestEntity request = RequestEntity.get(url).build();
        ResponseEntity response = restTemplate.exchange(url, HttpMethod.GET, request, Object.class);
        return response.getBody();
    }

    public Object makePostCall(String apiUrl, String apiEndpoint, HashMap<String, String>queryParams, Object requestBody){
        URI url = this.getFinalUrl(apiUrl, apiEndpoint, queryParams);
        RequestEntity request = RequestEntity.post(url).body(requestBody);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, request, Object.class);
        return response.getBody();
    }

    public Object makePutCall(String apiUrl, String apiEndpoint, HashMap<String, String>queryParams, Object requestBody){
        URI url = this.getFinalUrl(apiUrl, apiEndpoint, queryParams);
        RequestEntity request = RequestEntity.put(url).body(requestBody);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.PUT, request, Object.class);
        return response.getBody();
    }
}
