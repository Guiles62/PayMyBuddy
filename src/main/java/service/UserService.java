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
        User user1 = new User();
        User user2 = new User();
        user1.setFirstname("guillaume");
        user1.setLastname("neo");
        user1.setEmail("guiles@gmail.com");
        user1.setPassword("guiles");
        user1.setRole(new Role("admin"));
        user1.setBankAccount(new BankAccount("1234"));
        user1.setPmbAccount(new PmbAccount(4321,1000));
        userRepository.save(user1);

        user2.setFirstname("neo");
        user2.setLastname("guillaume");
        user2.setEmail("neo@gmail.com");
        user2.setPassword("neo");
        user2.setRole(new Role("user"));
        user2.setBankAccount(new BankAccount("4321"));
        user2.setPmbAccount(new PmbAccount(1234,1000));
        userRepository.save(user2);

        return saveUser(user);
    }

}
