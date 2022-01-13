package com.paymybuddy.paymybuddy.controllerTest;

import com.paymybuddy.paymybuddy.controller.BankTransactionController;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.service.BankTransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BankTransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    UserDetailsService userDetailsService;

    @Mock
    BankTransactionController bankTransactionController;

    @Mock
    BankTransactionService bankTransactionService;

    private User user;
    private Model model;

    @BeforeEach
    public void setup() {
        bankTransactionController = new BankTransactionController(bankTransactionService);
        user = (User) userDetailsService.loadUserByUsername("gui@gmail.com");
    }

    @Test
    public void getBankTransactionsTest() throws Exception {
        mockMvc.perform(get("/banktransaction")).andExpect(status().isOk());
    }

    @Test
    public void saveBankTransactionTest() {
        bankTransactionController.saveBankTransaction(user,"1234",100,model);
        verify(bankTransactionService,times(1)).saveBankTransaction(user,"1234",100);
    }

    @Test
    public void savePMBTransactionTest() {
        bankTransactionController.savePMBTransaction(user,"1234",100,model);
        verify(bankTransactionService,times(1)).savePMBTransaction(user,"1234",100);
    }
}
