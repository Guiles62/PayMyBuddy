package com.paymybuddy.paymybuddy.repository;

import com.paymybuddy.paymybuddy.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository <User, Integer>{

     User findByEmail(String email);
     User findByFirstname( String firstname);
     User findByEmailAndPassword(String email,String password);



}
