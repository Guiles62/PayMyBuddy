package com.paymybuddy.paymybuddy.serviceTest;


import com.paymybuddy.paymybuddy.model.Transaction;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.repository.TransactionRepository;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import com.paymybuddy.paymybuddy.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionServiceTest {

    @Autowired
    MockMvc mockMvc;

    private TransactionService transactionService;

    @Mock
    UserRepository userRepository;

    @Mock
    TransactionRepository transactionRepository;

    @BeforeEach
    void setup() {
        transactionService = new TransactionService(transactionRepository,userRepository);

    }

    @Test
    public void saveTransactionTest() {
        Transaction transaction = new Transaction();
        User user = new User();
        user.setBalance(1000);
        user.setEmail("gui@gmail.com");
        user.setFirstname("gui");
        user.setLastname("gui");
        user.setPassword("1234");
        user.setBalance(1000);
        when(userRepository.findByEmail("gui@gmail.com")).thenReturn(user);
        User user2 = new User();
        user2.setBalance(1000);
        user2.setEmail("est@gmail.com");
        user2.setFirstname("est");
        user2.setLastname("est");
        user2.setPassword("1234");
        user2.setBalance(1000);
        when(userRepository.findByFirstname("gui")).thenReturn(user2);
        when(transactionRepository.save(transaction)).thenReturn(transaction);
        transactionService.saveTransaction(user,"gui","abcd",100);
        verify(transactionRepository,times(1)).save(transaction);
    }

    @Test
    public void findByUserTransmitterTest() {
        User user = new User();
        Transaction transaction = new Transaction();
        transaction.setUserTransmitter(user);
        List<Transaction> userTransaction = new ArrayList<>();
        userTransaction.add(transaction);
        when(transactionRepository.findByUserTransmitter(user)).thenReturn(userTransaction);
        transactionService.findByUserTransmitter(user);
        verify(transactionRepository,times(1)).findByUserTransmitter(user);
    }
}
