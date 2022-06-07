package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Account;
import com.example.demo.model.User;
import com.example.demo.repository.AccountRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AccountRepo acountRepo;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Account account = new Account("1","Bob1",350L);
        Account account1 = new Account("2","Alice1",400L);
        Account account5 = new Account("6","Alice2",450L);
        Account account2 = new Account("5","Bob2",500L);
        Account account3 = new Account("3","Tom1",700L);
        Account account4 = new Account("4","Sara1",280L);





        List<Account> accountsBob = new ArrayList<>();
        accountsBob.add(account);
        accountsBob.add(account2);
        acountRepo.saveAll(accountsBob);
        User user1 = new User("1","Bob",accountsBob);
        userRepo.save(user1);

        List<Account> accountsAlice = new ArrayList<>();
        accountsAlice.add(account1);
        accountsAlice.add(account5);
        acountRepo.saveAll(accountsAlice);
        User user2 = new User("2","Alice",accountsAlice);
        userRepo.save(user2);

        List<Account> accountsTom = new ArrayList<>();
        accountsTom.add(account3);
        acountRepo.saveAll(accountsTom);
        User user3 = new User("3","Tom",accountsTom);
        userRepo.save(user3);

        List<Account> accountsSara = new ArrayList<>();
        accountsSara.add(account4);
        acountRepo.saveAll(accountsSara);
        User user4 = new User("4","Sara",accountsSara);
        userRepo.save(user4);
    }
}
