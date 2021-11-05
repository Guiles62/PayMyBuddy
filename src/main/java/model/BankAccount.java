package model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@DynamicUpdate
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
}
