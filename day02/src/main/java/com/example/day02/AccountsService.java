package com.example.day02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component
public class AccountsService {
    @Autowired
    AccountsRepository accountsRepository;

    @Autowired
    StatementsRepository statementsRepository;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deposit(int accountNumber,int amount, String type) {
        Accounts accounts = new Accounts();

        if(accountsRepository.existsById(accountNumber)) {
            accounts = accountsRepository.findById(accountNumber).get();
            int currentBalance = accounts.getBalance();
            currentBalance = currentBalance + amount;
            accounts.setBalance(currentBalance);
        } else {
            accounts.setAccount_number(accountNumber);
            accounts.setBalance(amount);
        }
        accountsRepository.save(accounts);

        Statements statements = new Statements(accountNumber, amount, type);
        statementsRepository.save(statements);
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void withdraw(int accountNumber,int amount, String type) {
        Accounts accounts = new Accounts();

        if(accountsRepository.existsById(accountNumber)) {
            accounts = accountsRepository.findById(accountNumber).get();
            int currentBalance = accounts.getBalance();

            currentBalance = currentBalance - amount;
            accounts.setBalance(currentBalance);
        } else {
            accounts.setAccount_number(accountNumber);
            accounts.setBalance(amount);
        }
        accountsRepository.save(accounts);

        Statements statements = new Statements(accountNumber, amount, type);
        statementsRepository.save(statements);
    }
}
