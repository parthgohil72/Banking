package com.ebanking.accounts.Service.Impl;

import com.ebanking.accounts.Constants.Constants;
import com.ebanking.accounts.DTO.AccountDTO;
import com.ebanking.accounts.DTO.CustomerDTO;
import com.ebanking.accounts.Exception.CustomerAlreadyExistsExcep;
import com.ebanking.accounts.Exception.ResourceNotFoundException;
import com.ebanking.accounts.Mapper.AccountMapper;
import com.ebanking.accounts.Mapper.CustomerMapper;
import com.ebanking.accounts.Model.Accounts;
import com.ebanking.accounts.Model.Customer;
import com.ebanking.accounts.Repository.AccountRepository;
import com.ebanking.accounts.Repository.CustomerRepository;
import com.ebanking.accounts.Service.IAccountIService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountIService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByNumber(customerDTO.getNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsExcep("Customer already exists with given phone number"
                    + customerDTO.getNumber());
        }
        Customer saveCustomer = customerRepository.save(customer);
        accountRepository.save(createAccount(saveCustomer));
    }


    private Accounts createAccount(Customer customer) {
        Accounts accounts = new Accounts();
        accounts.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        accounts.setAccountNumber(randomAccNumber);
        accounts.setAccountType(Constants.SAVINGS);
        accounts.setBranchAddress(Constants.ADDRESS);
        return accounts;
    }

    @Override
    public CustomerDTO getCustomerByNumber(String number) {
        Customer customer = customerRepository.findByNumber(number).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "Mobile No", number)
        );

        Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "Customer ID", customer.getCustomerId().toString())
        );

        CustomerDTO customerDTO = CustomerMapper.mapToCustomerDto(customer, new CustomerDTO());
        customerDTO.setAccountDTO(AccountMapper.mapToAccountDTO(accounts, new AccountDTO()));
        return customerDTO;
    }

    @Override
    public boolean updateAccount(CustomerDTO customerDTO) {
        boolean isUpdated = false;
        AccountDTO accountDTO = customerDTO.getAccountDTO();
        if (accountDTO != null) {
            Accounts accounts = accountRepository.findById(accountDTO.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "Account Number", accountDTO.getAccountNumber().toString())
            );
            AccountMapper.mapToAccounts(accountDTO, accounts);
            accounts = accountRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "Customer ID", customerId.toString())
            );
            CustomerMapper.mapToCustomer(customerDTO, customer);
            customer = customerRepository.save(customer);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String number) {
        Customer customer = customerRepository.findByNumber(number).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "Mobile No", number)
        );
        accountRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }
}
