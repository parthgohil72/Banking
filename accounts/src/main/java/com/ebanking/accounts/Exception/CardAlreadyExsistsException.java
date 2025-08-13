package com.ebanking.accounts.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CardAlreadyExsistsException extends RuntimeException {
    public CardAlreadyExsistsException(String message) {
        super(message);
    }
}
