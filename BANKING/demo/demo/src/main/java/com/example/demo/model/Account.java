package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    @Id
    private String id;
    private String name;
    private long account_balance;
    
    
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
    
    public Account(String id, String name, long account_balance) {
        this.id = id;
        this.name = name;
        this.account_balance = account_balance;
    }

}
