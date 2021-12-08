package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.paymybuddy.paymybuddy.service.BankAccountService;

@Controller
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping (value = "bankAccount")
    public Iterable<BankAccount> getBankAccount() {
        return bankAccountService.getBankAccount();
    }

    @PostMapping ( value = "bankAccount/newAccount")
    public BankAccount addBankAccount (BankAccount bankAccount) {
        return bankAccountService.addBankAccount(bankAccount);
    }

    @DeleteMapping ( value = "bankAccount")
    public void deleteBankAccount (BankAccount bankAccount) {
        bankAccountService.deleteBankAccount(bankAccount);
    }
}
