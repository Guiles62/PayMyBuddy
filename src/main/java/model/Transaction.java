package model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;


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
    private LocalDate dateTransaction;

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

}
