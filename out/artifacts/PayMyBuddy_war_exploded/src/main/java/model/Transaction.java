package model;

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

    @Column ( name = "transaction_number")
    private int transactionNumber;

    @Column ( name = "date_transaction")
    private LocalDateTime dateTransaction;

    @Column ( name = "description")
    private String description;

    @Column ( name = "amount")
    private int amount;

    @Column ( name = "cost")
    private int cost;

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn ( name = "pmb_account_id")
    private PmbAccount pmbAccount;

    public Transaction(int transactionId, int transactionNumber, LocalDateTime dateTransaction, String description, int amount, int cost, PmbAccount pmbAccount) {
        this.transactionId = transactionId;
        this.transactionNumber = transactionNumber;
        this.dateTransaction = dateTransaction;
        this.description = description;
        this.amount = amount;
        this.cost = cost;
        this.pmbAccount = pmbAccount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
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

    public PmbAccount getPmbAccount() {
        return pmbAccount;
    }

    public void setPmbAccount(PmbAccount pmbAccount) {
        this.pmbAccount = pmbAccount;
    }
}
