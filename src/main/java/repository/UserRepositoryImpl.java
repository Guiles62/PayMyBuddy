package repository;


import model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository{

    User user;

    public Iterable<User> findAll() {
        return findAll();
    }

    public User save( User user ) {
        return save(user);
    }

    public void deleteById(Integer id) {
        deleteById(id);
    }

    public Optional<User> findById (Integer id) {
        return findById(id);
    }


    public Iterable<User> findByUserEmail ( String email){
        return findByUserEmail(email);
    }

    public User saveByUserFriendsEmail(String email) {
        User userFind = (User) findByUserEmail(email);
        user.getUserFriends().add(userFind);
        return saveByUserFriendsEmail(email);
    }

}
