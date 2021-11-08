package model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table ( name = "role")
public class Role {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column ( name = "role_id")
    private int roleId;

    @Column( name = "libelle")
    private String libelle;

    @OneToOne ( mappedBy = "role")
    private User user;

}
