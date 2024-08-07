package com.example.Banking_App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Banking_App.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
