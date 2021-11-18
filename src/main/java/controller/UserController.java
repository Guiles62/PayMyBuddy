package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping (value = "user/{id}")
    public Optional<User> getUserById (@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping(value = "friends")
    public User addUserFriends(@RequestBody String email) {
        return userService.saveUserByEmail(email);
    }

    @GetMapping(value = "user/{email}")
    public Iterable<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping(value = "user/login")
    public User getUserByEmailAndPassword(@RequestBody String email, @RequestBody String password) {
        return userService.getUserByEmailAndPassword(email,password);
    }
    @PostMapping(value = "user/newuser")
    public User addUser ( User user) {
        return userService.addUser(user);
    }

    @DeleteMapping( value = "user")
    public void deleteUserById (Integer id) {
        userService.deleteUserById(id);
    }

}
