package com.example.Banking_App.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Banking_App.Entity.Account;
import com.example.Banking_App.Repository.AccountRepository;

@Service
public class AccountService {
	
	 @Autowired
	    private AccountRepository accountRepository;

	    public Account createAccount(String accountHolder, double initialDeposit) {
	        Account account = new Account();
	        account.setName(accountHolder);
	        account.setBalance(initialDeposit);
	        return accountRepository.save(account);
	    }

	    public Account deposit(Long accountId, double amount) {
	        Account account = accountRepository.findById(accountId).orElseThrow(() -> new IllegalArgumentException("Account not found"));
	        account.setBalance(account.getBalance() + amount);
	        return accountRepository.save(account);
	    }

	    public Account withdraw(Long accountId, double amount) {
	        Account account = accountRepository.findById(accountId).orElseThrow(() -> new IllegalArgumentException("Account not found"));
	        if (account.getBalance() < amount) {
	            throw new IllegalArgumentException("Insufficient balance");
	        }
	        account.setBalance(account.getBalance() - amount);
	        return accountRepository.save(account);
	    }

	    public Account getAccountDetails(Long accountId) {
	        return accountRepository.findById(accountId)
	                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
	    }
}
