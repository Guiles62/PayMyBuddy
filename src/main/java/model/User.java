package model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table ( name = "User")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column ( name = "user_id")
    private int userId;

    @Column ( name = "firstname")
    private String firstname;

    @Column ( name = "lastname")
    private String lastname;

    @Column ( name = "email")
    private String email;

    @Column ( name = "password")
    private String password;

    @OneToOne ( cascade = CascadeType.ALL)
    @JoinColumn ( name = "role_id", referencedColumnName = "role_id")
    private Role role;

    @OneToOne (mappedBy = "user")
    private BankAccount bankAccount;

    @OneToOne ( mappedBy = "user")
    private PmbAccount pmbAccount;
}
