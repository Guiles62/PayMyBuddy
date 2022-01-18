package com.paymybuddy.paymybuddy.serviceTest;


import com.paymybuddy.paymybuddy.model.BankTransaction;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.repository.BankTransactionRepository;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import com.paymybuddy.paymybuddy.service.BankTransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BankTransactionServiceTest {

    private static BankTransactionService bankTransactionService;
    private User user;
    private BankTransaction bankTransaction;


    @Mock
    BankTransactionRepository bankTransactionRepository;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setup() {
        bankTransactionService = new BankTransactionService(bankTransactionRepository,userRepository);

    }

  /* @Test
    public void saveBankTransactionTest() {
        User user = new User();
        BankTransaction bankTransaction = new BankTransaction();
        bankTransactionService.saveBankTransaction(user,"1234",100);
        when(userRepository.findByEmail("gui@gmail.com")).thenReturn(user);
        verify(bankTransactionRepository,times(1)).save(any(Transaction.class));
    }

   /* @Test
    @WithMockUser(username = "gui@gmail.com")
    public void savePMBTransactionTest() {
        BankTransaction bankTransaction = new BankTransaction();
        when(bankTransactionRepository.save(bankTransaction)).thenReturn(bankTransaction);
        bankTransactionService.savePMBTransaction(user,"1234",100);
        verify(bankTransactionRepository,times(1)).save(any(Transaction.class));
    }*/

}
