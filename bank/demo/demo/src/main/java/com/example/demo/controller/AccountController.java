package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.TransferRequest;
import com.example.demo.service.TradeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private TradeService tradeService;
    @PostMapping("/transfer")
    @Operation(summary = "Transfer money")
    public ResponseEntity<String> transfer (@RequestBody TransferRequest transferRequest){
       return ResponseEntity.ok(tradeService.transfer(transferRequest.accountA(),transferRequest.accountB(),transferRequest.amount()));
    }
}
