package com.ebanking.accounts.DTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CustomerDTO {
    private String name;

    private String email;

    private String number;

    AccountDTO accountDTO;
}
