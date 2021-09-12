package tn.formalab.HRApp.models;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name= "conges")
public class Conge {
    @Id
    @GeneratedValue
    public Integer id;

    @Column(name="typeConge")
    public String typeConge;

    @Column(name="debutConge")
    public Date debutConge;

    @Column(name="finConge")
    public Date finConge;

    @Column(name="createdAt")
    public Date createdAt;

    @Column(name="description")
    public String description;

    @Column(name="duree")
    public String duree;

    @Column(name="soldeConge")
    public Integer soldeConge;

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    private User user;
}
