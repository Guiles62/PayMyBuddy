package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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


    @GetMapping (value = "/user/{id}")
    public Optional<User> getUserById (@PathVariable Integer id){
        return userService.getUserById(id);
    }



    @GetMapping(value = "/newfriend")
    public String getUserByEmail(Model model) {
    return "newfriend";
    }

    @PostMapping(value="/addfriend")
    public User addFriend (@RequestParam("email") String email, Model model){
        return userService.addFriend(email);
    }

    @GetMapping( value = "/registration")
    public String registration (Model model) {
        return "registration";
    }

    @PostMapping(value = "/newuser")
    public User saveUser ( @RequestParam("firstname") String firstname,
                           @RequestParam("lastname") String lastname,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password,
                           Model model) {
        return userService.saveUser(firstname,lastname, email, password);
    }

    @GetMapping(value = "/profil")
    public String findUser(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
            model.addAttribute("userDetails",userDetails);
        }
        return "profil";
    }

    @GetMapping(value="/login")
    public String login (Model model) {
        return "login";
    }
}
