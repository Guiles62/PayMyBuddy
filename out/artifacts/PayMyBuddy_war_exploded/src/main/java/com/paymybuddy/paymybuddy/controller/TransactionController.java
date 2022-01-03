package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.model.Transaction;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/transactions")
    public String getUserTransactions(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            User userDetails = (User) auth.getPrincipal();
            List<User> userFriends = userDetails.getUserFriends();
            model.addAttribute("userfriends",userFriends);
        }
        return "transactions";
    }

    @PostMapping(value = "/newtransaction")
    public Transaction addTransaction (@RequestParam("userfriends") User user,
                                       @RequestParam("description") String description,
                                       @RequestParam("amount") int amount,
                                       Model model) {
        return transactionService.saveTransaction(user,description,amount);
    }

}
