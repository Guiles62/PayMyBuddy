package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.service.BankTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BankTransactionController {

    @Autowired
    private BankTransactionService bankTransactionService;

    public BankTransactionController(BankTransactionService bankTransactionService) {
        this.bankTransactionService = bankTransactionService;
    }

    @GetMapping(value="banktransaction")
    public String getBankTransactions(Model model) {
        return "banktransaction";
    }

    @PostMapping(value= "/newbanktransaction")
    public String saveBankTransaction(@AuthenticationPrincipal User user,
                                      @RequestParam String rib,
                                      @RequestParam int amount,
                                      Model model) {
        bankTransactionService.saveBankTransaction(user,rib,amount);
        return "redirect:/transactions";
    }
    @PostMapping(value="/newpmbtransaction")
    public String savePMBTransaction(@AuthenticationPrincipal User user,
                                           @RequestParam String rib,
                                           @RequestParam int amount,
                                           Model model) {
        bankTransactionService.savePMBTransaction(user,rib,amount);
        return "redirect:/transactions";
    }

}
