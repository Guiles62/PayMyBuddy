package service;


import model.BankAccount;
import model.PmbAccount;
import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;


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
        return userRepository.findByUserEmail(email);
    }

    public User saveByUserFriendsEmail(String email) {
        return userRepository.saveByUserFriendsEmail(email);
    }

    public List<User> findUserFriends (User user) {
        return userRepository.findUserFriends(user);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }


}
