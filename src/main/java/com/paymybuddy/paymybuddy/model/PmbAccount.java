package com.paymybuddy.paymybuddy.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
@Table ( name = "pmb_account")
public class PmbAccount {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column ( name = "pmb_account_id")
    private int pmbAccountId;

    @Column ( name = "account_number")
    private int accountNumber;

    @Column ( name = "account_balance")
    private int balance;

    @OneToMany(
            mappedBy = "pmbAccount",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<Transaction> transactions = new ArrayList<>();

    @OneToOne ( cascade = CascadeType.ALL)
    @JoinColumn ( name = "user_id", referencedColumnName = "user_id")
    private User user;

    public int getPmbAccountId() {
        return pmbAccountId;
    }

    public void setPmbAccountId(int pmbAccountId) {
        this.pmbAccountId = pmbAccountId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
