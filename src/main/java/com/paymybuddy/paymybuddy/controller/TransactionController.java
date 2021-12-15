package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.model.Transaction;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/transactions")
    public String getTransactions (Model model){
        return "transactions";
    }
    @PostMapping(value = "/newtransaction")
    public Transaction addTransaction (@RequestParam("user") User user,
                                       @RequestParam("description") String description,
                                       @RequestParam("amount") int amount,
                                       Model model) {
        return transactionService.saveTransaction(user,description,amount);
    }

}
