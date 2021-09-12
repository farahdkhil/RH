package tn.formalab.HRApp.models;
import javax.persistence.*;
@Entity
@Table(name= "depenses")
public class Depense {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(name="budget")
    public Double budget;

    @Column(name="depense")
    public String depense;

    @Column(name="description")
    public String description;

    @Column(name="montant")
    public Double montant;

}
