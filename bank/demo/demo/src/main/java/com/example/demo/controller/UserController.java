package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Account;
import com.example.demo.model.User;
import com.example.demo.repository.AccountRepo;
import com.example.demo.repository.UserRepo;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AccountRepo acountRepo;


    @GetMapping("user/{id}")
    @Operation(summary = "find user by id")
    public ResponseEntity<?> userById(@PathVariable(name = "id") String id){
        Optional<User> userOptional = userRepo.findById(id);
        User user = new User();
        if(userOptional.isPresent()){
             user = userOptional.get();
        }
        else {
            throw new NotFoundException("User with id = " + id + " not found");
        }
        return  ResponseEntity.ok(user);
    }

    @GetMapping("account/{id}")
    @Operation(summary = "find account by id")
    public ResponseEntity<?> accountById(@PathVariable(name = "id") String id){
        Optional<Account> accountOptional = acountRepo.findById(id);
        Account account = new Account();
        if(accountOptional.isPresent()){
            account = accountOptional.get();
        }
        else {
            throw new NotFoundException("Account with id = " + id + " not found");
        }
        return  ResponseEntity.ok(account);
    }

    @GetMapping("accountByUserId/{id}")
    @Operation(summary = "find account by user id")
    public ResponseEntity<?> accountByUserId(@PathVariable(name = "id") String id){
        Optional<User> userOptional = userRepo.findById(id);
        User user = new User();
        if(userOptional.isPresent()){
            user = userOptional.get();
        }
        else {
            throw new NotFoundException("Account with id = " + id + " not found");
        }
        List<Account> accountList = acountRepo.findAllByUser(user);
        return  ResponseEntity.ok(accountList);
    }

    

}
