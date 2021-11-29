package repository;

import model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository <User, Integer>{

     Iterable<User> findByUserEmail(String email);

     User saveByUserFriendsEmail(String email);

     List<User> findUserFriends( User user);
}
