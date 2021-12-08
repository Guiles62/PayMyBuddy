package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.model.PmbAccount;
import com.paymybuddy.paymybuddy.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.paymybuddy.paymybuddy.service.PmbAccountService;

import java.util.List;

@Controller
public class PmbAccountController {

    @Autowired
    private PmbAccountService pmbAccountService;

    @GetMapping( value = "pmbAccount")
    public Iterable<PmbAccount> getPmbAccount() {
        return pmbAccountService.getPmbAccount();
    }

    @PostMapping( value = "pmbAccount/newAccount")
    public PmbAccount addPmbAccount(@RequestBody PmbAccount pmbAccount) {
        return pmbAccountService.addPmbAccount(pmbAccount);
    }

    @DeleteMapping (value = "pmbAccount")
    public void deletePmbAccount (PmbAccount pmbAccount) {
        pmbAccountService.deletePmbAccount(pmbAccount);
    }

}
