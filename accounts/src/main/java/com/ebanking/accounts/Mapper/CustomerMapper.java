package com.ebanking.accounts.Mapper;

import com.ebanking.accounts.DTO.CustomerDTO;
import com.ebanking.accounts.Model.Customer;

public class CustomerMapper {
    public static CustomerDTO mapToCustomerDto(Customer customer, CustomerDTO customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setNumber(customer.getNumber());
        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDTO customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setNumber(customerDto.getNumber());
        return customer;
    }
}
