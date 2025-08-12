package com.ebanking.accounts.Exception;

import com.ebanking.accounts.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExistsExcep.class)
    public ResponseEntity<ErrorDTO> handleCustomerAlreadyExist(CustomerAlreadyExistsExcep customerAlreadyExistsExcep, WebRequest webRequest) {
        ErrorDTO errorDTO = new ErrorDTO(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                customerAlreadyExistsExcep.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleResourceNotFound(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest) {
        ErrorDTO errorDTO = new ErrorDTO(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                resourceNotFoundException.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

}
