package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "transactions")
    public String getTransactions (@RequestParam String email, Model model){
        model.addAttribute("transaction", transactionService.findTransactionsByUserEmail(email));
        return "transactions";
    }


}
