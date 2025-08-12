package com.ebanking.accounts.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistsExcep extends RuntimeException{

    public CustomerAlreadyExistsExcep(String message){
        super(message);
    }
}
