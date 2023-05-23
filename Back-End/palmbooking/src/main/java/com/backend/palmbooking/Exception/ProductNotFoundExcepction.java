package com.backend.palmbooking.Exception;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ProductNotFoundExcepction extends RuntimeException{

    public ProductNotFoundExcepction (String message){
        super(message);
    }
}
