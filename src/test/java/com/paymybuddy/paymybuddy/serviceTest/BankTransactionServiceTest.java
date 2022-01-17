package com.paymybuddy.paymybuddy.serviceTest;


import com.paymybuddy.paymybuddy.model.BankTransaction;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.repository.BankTransactionRepository;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import com.paymybuddy.paymybuddy.service.BankTransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BankTransactionServiceTest {

    private BankTransactionService bankTransactionService;
    private User user;

    @Mock
    UserDetailsService userDetailsService;

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
    @WithMockUser(username = "gui@gmail.com")
    public void saveBankTransactionTest() {
        BankTransaction bankTransaction = new BankTransaction();
        when(bankTransactionRepository.save(bankTransaction)).thenReturn(bankTransaction);
        bankTransactionService.saveBankTransaction(user,"1234",100);
        verify(bankTransactionRepository,times(1)).save(bankTransaction);
    }

    @Test
    @WithMockUser(username = "gui@gmail.com")
    public void savePMBTransactionTest() {
        BankTransaction bankTransaction = new BankTransaction();
        when(bankTransactionRepository.save(bankTransaction)).thenReturn(bankTransaction);
        bankTransactionService.savePMBTransaction(user,"1234",100);
        verify(bankTransactionRepository,times(1)).save(bankTransaction);
    }

}
