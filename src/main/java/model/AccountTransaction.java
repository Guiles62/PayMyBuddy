package model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DynamicUpdate
@Table ( name = "transaction_account")
public class AccountTransaction {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column ( name = "transaction_account_id")
    private int transactionAccountId;

    @Column ( name = "date_transaction_account")
    private LocalDate transactionAccountDate;

    @Column ( name = "amount")
    private int amount;

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn ( name = "bank_account_id")
    private BankAccount bankAccount;


}
