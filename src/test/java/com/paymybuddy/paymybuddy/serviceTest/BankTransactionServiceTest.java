package com.paymybuddy.paymybuddy.serviceTest;


import com.paymybuddy.paymybuddy.model.BankTransaction;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.repository.BankTransactionRepository;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import com.paymybuddy.paymybuddy.service.BankTransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class BankTransactionServiceTest {

    private static BankTransactionService bankTransactionService;
    private User user;


    @Mock
    BankTransactionRepository bankTransactionRepository;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setup() {
        bankTransactionService = new BankTransactionService(bankTransactionRepository,userRepository);
        user = new User();
        user.setBalance(1000);
        user.setEmail("gui@gmail.com");
        user.setFirstname("gui");
        user.setLastname("gui");
        user.setPassword("1234");
        user.setBalance(1000);
        when(userRepository.findByEmail("gui@gmail.com")).thenReturn(user);
    }

    @Test
    public void saveBankTransactionTest() {
        BankTransaction bankTransaction = new BankTransaction();
        when(bankTransactionRepository.save(bankTransaction)).thenReturn(bankTransaction);
        bankTransactionService.saveBankTransaction(user,"1234",100);
        verify(bankTransactionRepository,times(1)).save(any(BankTransaction.class));
    }

    @Test
    public void savePMBTransactionTest() {
        BankTransaction bankTransaction = new BankTransaction();
        when(bankTransactionRepository.save(bankTransaction)).thenReturn(bankTransaction);
        bankTransactionService.savePMBTransaction(user,"1234",100);
        verify(bankTransactionRepository,times(1)).save(any(BankTransaction.class));
    }

}
