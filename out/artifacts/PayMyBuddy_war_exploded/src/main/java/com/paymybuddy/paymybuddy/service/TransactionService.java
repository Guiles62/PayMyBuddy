package com.paymybuddy.paymybuddy.service;

import com.paymybuddy.paymybuddy.model.Transaction;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.repository.TransactionRepository;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    private UserRepository userRepository;

    public List<Transaction> findTransactionsByUserEmail(String email) {
        return transactionRepository.findTransactionsByPmbAccountUserEmail(email);
    }
    public Transaction saveTransaction(User user,String description,int amount){
        userRepository.findByEmail(user.getEmail());
        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);
        return transactionRepository.save(transaction);
    }
}
