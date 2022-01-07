package com.paymybuddy.paymybuddy.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;





    @Test
    public void getUserByEmailTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/newfriend")).andExpect(status().isOk());
    }

    @Test
    public void deleteUserByEmailTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/deleteafriend")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "gui@gmail.com")
    public void addFriendTest() throws Exception {
        mockMvc.perform(post("/addfriend")
               .param("email","est@gmail.com"))
               .andExpect(status().isOk());
    }

    @Test
    public void registrationTest() throws Exception {
        mockMvc.perform(get("/registration")).andExpect(status().isOk());
    }
    @Test
    public void saveUserTest() throws Exception {
        mockMvc.perform(post("/newuser")
                .param("firstname","gui")
                .param("lastname","c")
                .param("email","@")
                .param("password","0"))
                .andExpect(status().isOk());
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
