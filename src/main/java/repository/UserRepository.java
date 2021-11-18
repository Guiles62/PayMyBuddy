package repository;

import model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository <User, Integer>{

     User save (User user);
     void deleteById (Integer id);
     Iterable<User> findByUserEmail(String email);
     User saveByUserFriendsEmail(String email);


}
