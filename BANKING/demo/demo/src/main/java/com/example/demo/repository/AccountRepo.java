package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Account;
import com.example.demo.model.User;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account,String> {
    List<Account> findAllByUser(User user);
}
