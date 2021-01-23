package com.seguro_canguro.code_challenge.infraestructure;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seguro_canguro.code_challenge.exception.BaseException;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class HttpRequest {

   
    public static String send(String url) {
        try {

            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(url, String.class);
            return result;
        } catch (HttpClientErrorException e) {

            throw new BaseException("Error send request : " + e.getMessage());
        }

    }

    public static Map<String, Object> mapperJsonResultToListMap(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new LinkedHashMap<>();

        try {
            map = mapper.readValue(json, Map.class);

        } catch (IOException e) {
            e.printStackTrace();
            throw new BaseException("Error in mapper");
        }

        return map;

    }


}
