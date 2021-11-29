package service;

import model.PmbAccount;
import model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PmbAccountRepository;

import java.util.ArrayList;


@Service
public class PmbAccountService {

    @Autowired
    private PmbAccountRepository pmbAccountRepository;

    public Iterable<PmbAccount> getPmbAccount() {
        return pmbAccountRepository.findAll();
    }

    public PmbAccount addPmbAccount(PmbAccount pmbAccount) {
        return pmbAccountRepository.save(pmbAccount);
    }

    public void deletePmbAccount(PmbAccount pmbAccount) {
        pmbAccountRepository.delete(pmbAccount);
    }

    public ArrayList<Transaction> getTransactionsByAccount(int accountNumber) {
        Iterable<PmbAccount> pmbAccountList = getPmbAccount();
        for ( PmbAccount pmbAccount : pmbAccountList ) {
            if ( pmbAccount.getAccountNumber() == accountNumber){
               ArrayList<Transaction> transactionsList = pmbAccount.getTransactions();
               return transactionsList;
            }
        }
        return getTransactionsByAccount(accountNumber);
    }



}
