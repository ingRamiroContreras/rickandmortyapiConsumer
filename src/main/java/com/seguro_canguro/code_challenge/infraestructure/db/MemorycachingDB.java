package com.seguro_canguro.code_challenge.infraestructure.db;

import java.util.HashMap;
import java.util.Map;

public class MemorycachingDB {


    private static Map<String, String> simpleBdKeyValue = new HashMap<>();


    public static void add(String key, String value){
        simpleBdKeyValue.put(key, value);
    }


    public static String get(String key){
        return simpleBdKeyValue.get(key);
    }

    
}
