package com.ebanking.accounts.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDTO {

    private String apiPath;
    private HttpStatusCode errorCode;
    private String errorMsg;
    private LocalDateTime errorTime;
}
