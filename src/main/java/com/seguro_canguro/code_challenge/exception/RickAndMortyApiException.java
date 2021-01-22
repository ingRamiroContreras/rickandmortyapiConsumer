package com.seguro_canguro.code_challenge.exception;

public class RickAndMortyApiException  extends BaseException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public RickAndMortyApiException(String message) {
        super("Error send request : " + message);
    }


    
    
}
