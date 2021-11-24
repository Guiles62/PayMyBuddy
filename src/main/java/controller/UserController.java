package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;

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
    public User saveUserFriends(@RequestBody String email) {
        return userService.saveByUserFriendsEmail(email);
    }

    @GetMapping(value = "friends")
    public List<User> findUserFriends (User user) {
        return userService.findUserFriends(user);
    }

    @GetMapping(value = "user/{email}")
    public Iterable<User> getUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @PostMapping(value = "user/newuser")
    public User saveUser ( User user) {
        return userService.saveUser(user);
    }


    @GetMapping(value = "/user")
    public String findUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "user";
    }
}
