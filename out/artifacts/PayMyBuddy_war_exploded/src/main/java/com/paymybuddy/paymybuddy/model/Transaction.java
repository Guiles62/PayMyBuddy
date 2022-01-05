package com.paymybuddy.paymybuddy.model;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@DynamicUpdate
@Table ( name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column ( name = "transaction_id")
    private int transactionId;

    @Column ( name = "date_transaction")
    private LocalDateTime dateTransaction;

    @Column ( name = "description")
    private String description;

    @Column ( name = "amount")
    private int amount;

    @Column ( name = "cost")
    private int cost;

    @OneToOne ()
    @JoinColumn ( name = "user_transmitter_id", referencedColumnName = "user_id")
    private User userTransmitter;

    @OneToOne ()
    @JoinColumn ( name = "user_recipient_id", referencedColumnName = "user_id")
    private User userRecipient;


    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(LocalDateTime dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public User getUserTransmitter() {
        return userTransmitter;
    }

    public void setUserTransmitter(User userTransmitter) {
        this.userTransmitter = userTransmitter;
    }

    public User getUserRecipient() {
        return userRecipient;
    }

    public void setUserRecipient(User userRecipient) {
        this.userRecipient = userRecipient;
    }
}
