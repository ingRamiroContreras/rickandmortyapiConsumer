package com.seguro_canguro.code_challenge.infraestructure;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seguro_canguro.code_challenge.exception.BaseException;
import com.seguro_canguro.code_challenge.exception.RickAndMortyApiException;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class Request {

    private String URL;

    private Request(String uRL) {
        URL = uRL;
    }

    public String sendRequest(){
        try {

            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(URL, String.class);
            return result;
        } catch (HttpClientErrorException e) {
           
            throw new RickAndMortyApiException(e.getMessage());
        }

    }

    public Map<String, Object> mapperJsonResultToListMap(String json) {
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

    
    public static Request create(String url){
        return new Request(url);
    }

    
    
}
