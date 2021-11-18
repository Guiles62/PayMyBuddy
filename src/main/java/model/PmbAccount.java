package model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@DynamicUpdate
@Table ( name = "pmb_account")
public class PmbAccount {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column ( name = "pmb_account_id")
    private int pmbAccountId;

    @Column ( name = "user_id")
    private int userId;

    @Column ( name = "account_number")
    private int accountNumber;

    @Column ( name = "account_balance")
    private int balance;

    @OneToMany(
            mappedBy = "pmbAccount",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    ArrayList<Transaction> transactions = new ArrayList<>();

    @OneToOne ( cascade = CascadeType.ALL)
    @JoinColumn ( name = "user_id", referencedColumnName = "user_id")
    private User user;


    public PmbAccount() {
        super();
    }


    public int getPmbAccountId() {
        return pmbAccountId;
    }

    public void setPmbAccountId(int pmbAccountId) {
        this.pmbAccountId = pmbAccountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
