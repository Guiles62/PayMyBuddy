package com.paymybuddy.paymybuddy.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paymybuddy.paymybuddy.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
    public void addFriendTest() throws Exception {

        mockMvc.perform(post("/addfriend")
                .content(asJsonString("gui@gmail.com"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void deleteFriendTest() throws Exception {

    }

    @Test
    public void registrationTest() throws Exception {
        mockMvc.perform(get("/registration")).andExpect(status().isOk());
    }
    @Test
    public void saveUserTest() throws Exception {
        User user = new User();
        user.setEmail("gui@gmail.com");
        user.setFirstname("gui");
        user.setLastname("c");
        user.setPassword("1234");
        mockMvc.perform(post("/newuser")
                .content(asJsonString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void findUserTest() throws Exception {
        mockMvc.perform(get("/profil")).andExpect(status().isOk());
    }
    @Test
    public void loginTest() throws Exception {
        mockMvc.perform(get("/profil")).andExpect(status().isOk());
    }
}
