package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.model.Transaction;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.repository.TransactionRepository;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;


    public Transaction saveTransaction(String firstname, String description, int amount) {
        Transaction transaction = new Transaction();
        float cost = (float) (amount * 0.05);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            User userDetails = (User) auth.getPrincipal();
            User userRecipient = userRepository.findByFirstname(firstname);
            transaction.setUserTransmitter(userDetails);
            transaction.setUserRecipient(userRecipient);
            transaction.setDescription(description);
            transaction.setDateTransaction(LocalDateTime.now());
            transaction.setAmount(amount);
            transaction.setCost(cost);
            transaction.getUserTransmitter().setBalance(userDetails.getBalance() - amount);
            transaction.getUserRecipient().setBalance(userRecipient.getBalance() + (amount - cost));
        }
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findByUserTransmitter(User user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            user = (User) auth.getPrincipal();
        }
        return transactionRepository.findByUserTransmitter(user);
    }
}
