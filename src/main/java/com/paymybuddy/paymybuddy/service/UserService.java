package com.paymybuddy.paymybuddy.service;


import com.paymybuddy.paymybuddy.model.Role;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUserEmail(String email) {
    return userRepository.findByEmail(email);
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
        user.setBalance(1000);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByEmail(s);
    }
    public User addFriend (User user, String email) {
            User userFriend = userRepository.findByEmail(email);
            user.getUserFriends().add(userFriend);
        return userRepository.save(user);
    }

    public User deleteFriend (User user,String email) {
            User userFriend = userRepository.findByEmail(email);
            user.getUserFriends().remove(userFriend);
        return userRepository.save(user);
    }

}
