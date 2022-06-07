package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.TradeException;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TradeService {
    @Autowired
    private AccountRepo accountRepo;


    public String transfer(String accountA,String accountB,long amount){
        Optional<Account> accountOptional = accountRepo.findById(accountA);
        Account accountSend = new Account();
        if(accountOptional.isPresent()){
            accountSend  = accountOptional.get();
        }
        else {
            throw new NotFoundException("Account with id = " + accountA + " not found");
        }
        Account accountReceive = new Account();
        if(accountOptional.isPresent()){
            accountReceive = accountOptional.get();
        }
        else {
            throw new NotFoundException("Account with id = " + accountB + " not found");
        }

        long monneyAccountSend = accountSend.getAccount_balance();
        long monneyAccountRecv = accountReceive.getAccount_balance();

        if(monneyAccountSend < 0){
            throw new TradeException("Tiền gửi ít hơn 0");
        }
        if(monneyAccountSend < amount){
            throw new TradeException("Số dư của bạn không đủ");
        }
        accountSend.setAccount_balance(monneyAccountSend - amount);
        accountReceive.setAccount_balance(monneyAccountRecv + amount);
        accountRepo.save(accountSend);
        accountRepo.save(accountReceive);
        return "Successfully transfer " + amount + " to " + accountReceive.getName();
    }
}
