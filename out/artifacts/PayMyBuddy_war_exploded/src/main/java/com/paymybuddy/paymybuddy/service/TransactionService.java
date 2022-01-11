package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.model.Transaction;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.repository.TransactionRepository;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {


    private TransactionRepository transactionRepository;
    private UserRepository userRepository;

    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    public Transaction saveTransaction(User user, String firstname, String description, int amount) {
        Transaction transaction = new Transaction();
        String email = user.getEmail();
        float cost = (float) (amount * 0.05);
            User userTransmitter = userRepository.findByEmail(email);
            User userRecipient = userRepository.findByFirstname(firstname);
            transaction.setUserTransmitter(userTransmitter);
            transaction.setUserRecipient(userRecipient);
            transaction.setDescription(description);
            transaction.setDateTransaction(LocalDateTime.now());
            transaction.setAmount(amount);
            transaction.setCost(cost);
            transaction.getUserTransmitter().setBalance(userTransmitter.getBalance() - amount);
            transaction.getUserRecipient().setBalance(userRecipient.getBalance() + (amount - cost));
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findByUserTransmitter(User user) {
        return transactionRepository.findByUserTransmitter(user);
    }
}
