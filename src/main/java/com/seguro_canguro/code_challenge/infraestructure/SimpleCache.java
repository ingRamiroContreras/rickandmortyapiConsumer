package com.seguro_canguro.code_challenge.infraestructure;

import com.seguro_canguro.code_challenge.domain.CachingMethod;

public class SimpleCache implements CachingMethod {

    @Override
    public void add(String key, String value) {
        MemorycachingDB.add(key, value);

    }

    @Override
    public String get(String key) {
        return   MemorycachingDB.get(key);
    }
    
}
