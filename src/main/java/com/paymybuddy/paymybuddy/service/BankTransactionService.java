package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.model.BankTransaction;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.repository.BankTransactionRepository;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BankTransactionService {

    private BankTransactionRepository bankTransactionRepository;
    private UserRepository userRepository;

    public BankTransactionService(BankTransactionRepository bankTransactionRepository, UserRepository userRepository) {
        this.bankTransactionRepository = bankTransactionRepository;
        this.userRepository = userRepository;
    }

    public BankTransaction saveBankTransaction(User user, String rib, int amount) {
        BankTransaction bankTransaction = new BankTransaction();
        String email = user.getEmail();
        User userTransmitter = userRepository.findByEmail(email);
        bankTransaction.setTransactionAccountDate(LocalDateTime.now());
        bankTransaction.setRib(rib);
        bankTransaction.setUser(userTransmitter);
        bankTransaction.setAmount(amount);
        bankTransaction.getUser().setBalance(userTransmitter.getBalance() - amount);
        return bankTransactionRepository.save(bankTransaction);
    }

    public BankTransaction savePMBTransaction(User user, String rib, int amount) {
        BankTransaction PMBTransaction = new BankTransaction();
        String email = user.getEmail();
        User userTransmitter = userRepository.findByEmail(email);
        PMBTransaction.setTransactionAccountDate(LocalDateTime.now());
        PMBTransaction.setRib(rib);
        PMBTransaction.setUser(userTransmitter);
        PMBTransaction.setAmount(amount);
        PMBTransaction.getUser().setBalance(userTransmitter.getBalance() + amount);
        return bankTransactionRepository.save(PMBTransaction);
    }
}
