package com.paymybuddy.paymybuddy.service;


import com.paymybuddy.paymybuddy.model.Role;
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

    public User addFriend(String email){
        User user = new User();
        Iterable<User> userFriend = findUserByEmail(email);
        user.getUserFriends().add((User) userFriend);
        return userRepository.save(user);
    }

    public User saveUser(String firstname,String lastname,String email,String password) {
        Role role = new Role();
        User user= new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPassword(password);
        role.setRoleId(2);
        role.setLibelle("USER");
        user.setRole(role);
        return userRepository.save(user);
    }



}
