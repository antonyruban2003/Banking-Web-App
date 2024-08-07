package com.example.Banking_App.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Banking_App.Entity.Account;
import com.example.Banking_App.Service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account accountRequest) {
        return accountService.createAccount(accountRequest.getName(), accountRequest.getBalance());
    }

    @PostMapping("/{accountId}/deposit")
    public Account deposit(@PathVariable Long accountId, @RequestParam double amount) {
        return accountService.deposit(accountId, amount);
    }

    @PostMapping("/{accountId}/withdrawal")
    public Account withdraw(@PathVariable Long accountId, @RequestParam double amount) {
        return accountService.withdraw(accountId, amount);
    }

    @GetMapping("/{accountId}")
    public Account getAccountDetails(@PathVariable Long accountId) {
        return accountService.getAccountDetails(accountId);
    }

	  
	 

}
