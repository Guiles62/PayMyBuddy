package com.paymybuddy.paymybuddy.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
@Table ( name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column ( name = "bank_account_id")
    private int bankAccountId;


    @Column ( name = "rib")
    private String rib;

    @OneToMany(
            mappedBy = "bankAccount",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<AccountTransaction> accountTransactions = new ArrayList<>();

    @OneToOne ( cascade = CascadeType.ALL)
    @JoinColumn ( name = "user_id", referencedColumnName = "user_id")
    private User user;

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public List<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(List<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
