package com.paymybuddy.paymybuddy.repository;

import com.paymybuddy.paymybuddy.model.PmbAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PmbAccountRepository extends CrudRepository<PmbAccount, Integer> {



}
