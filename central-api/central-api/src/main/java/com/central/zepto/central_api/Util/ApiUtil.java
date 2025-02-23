package com.central.zepto.central_api.Util;

import java.util.HashMap;

public interface ApiUtil {
    //this is util class
    public Object makeGetCall(String apiUrl, String apiEndpoint, HashMap<String, String>queryParams);
    public Object makePostCall(String apiUrl, String apiEndpoint, HashMap<String, String>queryParams, Object requestBody);
    public Object makePutCall(String apiUrl, String apiEndpoint, HashMap<String, String>queryParams, Object requestBody);
}
