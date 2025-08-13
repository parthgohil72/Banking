package com.ebanking.accounts.Service;

import com.ebanking.accounts.DTO.CustomerDTO;
import org.springframework.stereotype.Service;

public interface IAccountIService {


    void createAccount(CustomerDTO customerDTO);

    CustomerDTO getCustomerByNumber(String number);

    boolean updateAccount(CustomerDTO customerDTO);

    boolean deleteAccount(String number);
}
