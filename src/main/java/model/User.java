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

}
