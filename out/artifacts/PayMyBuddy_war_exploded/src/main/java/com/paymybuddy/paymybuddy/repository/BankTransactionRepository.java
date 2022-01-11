package com.paymybuddy.paymybuddy.repository;

import com.paymybuddy.paymybuddy.model.BankTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankTransactionRepository extends CrudRepository<BankTransaction,Integer> {


}
