package com.ebanking.accounts.DTO;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;

@Data
public class AccountDTO {

    private Long accountNumber;

    private String accountType;

    private String branchAddress;
}
