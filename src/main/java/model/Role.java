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

    public Role(int roleId, String libelle, User user) {
        this.roleId = roleId;
        this.libelle = libelle;
        this.user = user;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
