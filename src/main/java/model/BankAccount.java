package model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@DynamicUpdate
@Table ( name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column ( name = "bank_account_id")
    private int bankAccountId;

    @Column ( name = "user_id")
    private int userId;

    @Column ( name = "rib")
    private String rib;

    @OneToMany(
            mappedBy = "bankAccount",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    ArrayList<AccountTransaction> accountTransactions = new ArrayList<>();

    @OneToOne ( cascade = CascadeType.ALL)
    @JoinColumn ( name = "user_id", referencedColumnName = "user_id")
    private User user;

    public BankAccount(int bankAccountId, int userId, String rib, ArrayList<AccountTransaction> accountTransactions, User user) {
        this.bankAccountId = bankAccountId;
        this.userId = userId;
        this.rib = rib;
        this.accountTransactions = accountTransactions;
        this.user = user;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public ArrayList<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(ArrayList<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
