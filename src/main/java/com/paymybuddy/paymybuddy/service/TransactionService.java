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
    private UserRepository userRepository;

    public List<Transaction> findTransactionsByUserEmail(String email) {
        return transactionRepository.findTransactionsByPmbAccountUserEmail(email);
    }

    public Transaction saveTransaction(User user,String description,int amount) {
        Transaction transaction = new Transaction();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            User userDetails = (User) auth.getPrincipal();
            transaction.setDescription(description);
            transaction.setDateTransaction(LocalDateTime.now());
            transaction.setAmount(amount);
            transaction.setCost((int) (amount*0.05));
            transaction.setPmbAccount(userDetails.getPmbAccount());
            user.getPmbAccount().setBalance((int) (user.getPmbAccount().getBalance()+ amount/1.05));
        }
        return transactionRepository.save(transaction);
    }
}
