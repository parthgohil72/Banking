package com.ebanking.accounts.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {
    private String status_code;

    private String statusMsg;
}
