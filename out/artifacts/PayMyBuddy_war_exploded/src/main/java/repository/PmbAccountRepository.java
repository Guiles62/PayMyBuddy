package repository;

import model.PmbAccount;
import model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PmbAccountRepository extends CrudRepository<PmbAccount, Integer> {

    public ArrayList<Transaction> getTransactions(int accountNumber);
}
