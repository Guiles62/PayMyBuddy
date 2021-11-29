package service;

import model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BankAccountRepository;

import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public Iterable<BankAccount> getBankAccount() {
        return bankAccountRepository.findAll();
    }

    public Optional<BankAccount> getBankAccountById(Integer id) {
        return bankAccountRepository.findById(id);
    }

    public BankAccount addBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public void deleteBankAccount(BankAccount bankAccount) {
        bankAccountRepository.delete(bankAccount);
    }
}
