package service;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepositoryImpl;


import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    public Iterable<User> getUsers() {
        return userRepositoryImpl.findAll();
    }

    public User addUser(User user) {
        return userRepositoryImpl.save(user);
    }

    public void deleteUserById(Integer id) {
        userRepositoryImpl.deleteById(id);
    }

    public Optional<User> getUserById (Integer id) {
        return userRepositoryImpl.findById(id);
    }

    public Iterable<User> getUserByEmail(String email) {
        return userRepositoryImpl.findByUserEmail(email);
    }

    public User saveUserByEmail(String email) {
        return userRepositoryImpl.saveByUserFriendsEmail(email);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        Iterable<User> getUserList = getUsers();
        for ( User user : getUserList) {
            if ( user.getEmail().contains(email) && user.getPassword().contains(password)){
                return user;
            }
        }
        return getUserByEmailAndPassword(email,password);
    }

}
