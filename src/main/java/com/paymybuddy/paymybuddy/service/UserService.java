package com.paymybuddy.paymybuddy.service;


import com.paymybuddy.paymybuddy.model.Role;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public User addFriend(String email){
        User user = new User();
        List<User> friendsList = user.getUserFriends();;
        Iterable<User> userFriend = findUserByEmail(email);
        userFriend.forEach(friendsList::add);
        return userRepository.save(user);
    }

    public User saveUser(String firstname,String lastname,String email,String password) {
        Role role = new Role();
        role.setRoleId(2);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        User user= new User();
        user.setEmail(email);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setPassword(hashedPassword);
        user.setRole(role);
        return userRepository.save(user);
    }



}
