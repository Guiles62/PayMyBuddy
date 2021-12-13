package com.paymybuddy.paymybuddy.service;


import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById (Integer id) {
        return userRepository.findById(id);
    }

    public Iterable<User> findUserByEmail(String email) {
    return userRepository.findByEmail(email);
    }

    public User saveUser(String name,String email,String password) {
        User user= new User();
        user.setFirstname(name);
        user.setEmail(email);
        user.setPassword(password);
        return userRepository.save(user);
    }



}
