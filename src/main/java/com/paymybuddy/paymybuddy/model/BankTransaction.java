package com.paymybuddy.paymybuddy.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@DynamicUpdate
@Table ( name = "bank_transaction")
public class BankTransaction {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column ( name = "bank_transaction_id")
    private int transactionAccountId;

    @Column ( name = "date_transaction_account")
    private LocalDateTime transactionAccountDate;

    @Column ( name = "amount")
    private int amount;

    @Column ( name = "rib")
    private String rib;

    @OneToOne ( cascade = CascadeType.ALL)
    @JoinColumn ( name = "user_id", referencedColumnName = "user_id")
    private User user;

    public int getTransactionAccountId() {
        return transactionAccountId;
    }

    public void setTransactionAccountId(int transactionAccountId) {
        this.transactionAccountId = transactionAccountId;
    }

    public LocalDateTime getTransactionAccountDate() {
        return transactionAccountDate;
    }

    public void setTransactionAccountDate(LocalDateTime transactionAccountDate) {
        this.transactionAccountDate = transactionAccountDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
