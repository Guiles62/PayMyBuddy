package com.paymybuddy.paymybuddy.controllerTest;

import com.paymybuddy.paymybuddy.controller.TransactionController;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    UserDetailsService userDetailsService;

    @Mock
    TransactionController transactionController;

    @Mock
    TransactionService transactionService;

    private User user;
    private Model model;

    @BeforeEach
    public void setup() {
        transactionController = new TransactionController(transactionService);
        user = (User) userDetailsService.loadUserByUsername("gui@gmail.com");
    }


    @Test
    @WithMockUser(username="gui@gmail.com")
    public void getUserTransactionsTest() throws Exception {
        mockMvc.perform(get("/transactions")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "gui@gmail.com")
    public void saveTransactionTest() throws Exception {
        transactionController.saveTransaction(user,"estelle","test",100,model);
        verify(transactionService,times(1)).saveTransaction(user,"estelle","test",100);
    }
}
