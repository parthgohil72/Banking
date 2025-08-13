package com.ebanking.accounts.Mapper;

import com.ebanking.accounts.DTO.AccountDTO;
import com.ebanking.accounts.Model.Accounts;

public class AccountMapper {

    public static AccountDTO mapToAccountDTO(Accounts accounts, AccountDTO accountDTO){
        accountDTO.setAccountNumber(accounts.getAccountNumber());
        accountDTO.setAccountType(accounts.getAccountType());
        accountDTO.setBranchAddress(accounts.getBranchAddress());
        return accountDTO;

    }

    public static Accounts mapToAccounts(AccountDTO accountDTO, Accounts accounts){
      accounts.setAccountNumber(accountDTO.getAccountNumber());
      accounts.setAccountType(accountDTO.getAccountType());
      accounts.setBranchAddress(accountDTO.getBranchAddress());
      return accounts;
    }
}
