package com.seguro_canguro.code_challenge.domain;

public interface CachingMethod {

    public void add(String key, String value);
    public String get(String key);

}
