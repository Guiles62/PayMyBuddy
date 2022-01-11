package com.paymybuddy.paymybuddy.serviceTest;

import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import com.paymybuddy.paymybuddy.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest {

    @Autowired
    MockMvc mockMvc;

    private UserService userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setup() {
    userService = new UserService(userRepository);
    }

    @Test
    public void findByUserEmailTest() {
        User user = new User();
        String email = user.getEmail();
        when(userRepository.findByEmail(email)).thenReturn(user);
        userService.findByUserEmail(email);
        verify(userRepository,times(1)).findByEmail(email);
    }

    @Test
    public void saveUserTest() {
        User user = new User();
        user.setEmail("est@gmail.com");
        String email = user.getEmail();
        user.setLastname("est");
        String lastname = user.getLastname();
        user.setPassword("0000");
        String password = user.getPassword();
        user.setFirstname("estelle");
        String firstname = user.getFirstname();
        when(userRepository.save(user)).thenReturn(user);
        userService.saveUser(firstname,lastname,email,password);
        verify(userRepository,times(1)).save(user);
    }

    @Test
    public void addFriendTest() {
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);
        userService.addFriend(user,"gui@gmail.com");
        verify(userRepository,times(1)).save(user);
    }

    @Test
    public void deleteFriendTest() {
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);
        userService.deleteFriend(user,"gui@gmail.com");
        verify(userRepository,times(1)).save(user);
    }

}
