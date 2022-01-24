package com.paymybuddy.paymybuddy.controller;

import com.paymybuddy.paymybuddy.model.Transaction;
import com.paymybuddy.paymybuddy.model.User;
import com.paymybuddy.paymybuddy.service.TransactionService;
import com.paymybuddy.paymybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    @Autowired
    private UserService userService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(value = "/transactions")
    public String getUserTransactions(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            String email = userDetails.getUsername();
            User user = userService.findByUserEmail(email);
            List<User> userFriends = user.getUserFriends();
            model.addAttribute("userfriends",userFriends);
            List<Transaction> transactionList = transactionService.findByUserTransmitter(user);
            model.addAttribute("transaction",transactionList);
        }
        return "transactions";
    }

    @PostMapping(value = "/newtransaction")
    public String saveTransaction (@AuthenticationPrincipal User user,
                                   @RequestParam("userfriends") String firstname,
                                   @RequestParam("description") String description,
                                   @RequestParam("amount") int amount,
                                   Model model) {
        if (transactionService.saveTransaction(user, firstname, description, amount) == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth instanceof AnonymousAuthenticationToken)) {
                UserDetails userDetails = (UserDetails) auth.getPrincipal();
                String email = userDetails.getUsername();
                User user2 = userService.findByUserEmail(email);
                List<User> userFriends = user2.getUserFriends();
                model.addAttribute("userfriends",userFriends);
                List<Transaction> transactionList = transactionService.findByUserTransmitter(user);
                model.addAttribute("transaction",transactionList);
            }
            model.addAttribute("error", "Your balance is insufficient");
            return "transactions";
        } else {
            return "redirect:transactions";
        }
    }
}
