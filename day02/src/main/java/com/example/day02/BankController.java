package com.example.day02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    AccountsRepository accountsRepository;

    @Autowired
    StatementsRepository statementsRepository;

    @Autowired
    AccountsService accountsService;

    @GetMapping("/getAllAccounts")
    public List<Accounts> getAllAccounts() {
        return accountsRepository.findAll();
    }

    @GetMapping("/getAllStatements")
    public List<Statements> getAllStatements() {
        return statementsRepository.findAll();
    }

    @PostMapping("/deposit")
    public void deposit(@RequestParam int accountNumber, @RequestParam int amount, @RequestParam String type) {
        accountsService.deposit(accountNumber, amount, type);
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestParam int accountNumber, @RequestParam int amount, @RequestParam String type) {
        accountsService.withdraw(accountNumber, amount, type);
    }
}
