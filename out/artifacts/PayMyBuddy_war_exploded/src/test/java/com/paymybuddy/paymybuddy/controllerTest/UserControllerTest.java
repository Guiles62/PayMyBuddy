package com.paymybuddy.paymybuddy.controllerTest;

import com.paymybuddy.paymybuddy.controller.UserController;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.Model;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    UserService userService;

    @Mock
    UserController userController;

    @Autowired
    UserDetailsService userDetailsService;

    private User user;
    private Model model;

    @BeforeEach
    public void setup() {

         user = (User) userDetailsService.loadUserByUsername("gui@gmail.com");
    }

    @Test
    public void getUserByEmailTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/newfriend")).andExpect(status().isOk());
    }

    @Test
    public void deleteUserByEmailTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/deleteafriend")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser()
    public void addFriendTest() throws Exception {
        userController.addFriend(user,"est@gmail.com",model);
        verify(userService,times(1)).addFriend(user,"est@gmail.com");

    }

    @Test
    public void registrationTest() throws Exception {
        mockMvc.perform(get("/registration")).andExpect(status().isOk());
    }
    @Test
    public void saveUserTest() throws Exception {

    }

    @Test
    @WithMockUser(username="gui@gmail.com")
    public void findUserTest() throws Exception {
        mockMvc.perform(get("/profil")).andExpect(status().isOk());
    }
    @Test
    public void loginTest() throws Exception {
        mockMvc.perform(get("/login")).andExpect(status().isOk());
    }
}
