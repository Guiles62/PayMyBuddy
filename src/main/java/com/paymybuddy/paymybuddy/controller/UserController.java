package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping (value = "user/{id}")
    public Optional<User> getUserById (@PathVariable Integer id){
        return userService.getUserById(id);
    }



    @GetMapping(value = "user/{email}")
    public Iterable<User> getUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping( value = "registration")
    public String registration (Model model) {
        return "registration";
    }

    @PostMapping(value = "/newuser")
    public User saveUser ( @RequestParam("name") String name,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password,
                           Model model) {
        return userService.saveUser(name, email, password);
    }


    @GetMapping(value = "/user")
    public String findUsers(Model model) {
        Iterable<User> userList = userService.getUsers();
        model.addAttribute("user", userList);
        return "profil";
    }

}
