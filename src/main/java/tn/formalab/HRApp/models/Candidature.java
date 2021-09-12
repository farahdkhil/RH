package tn.formalab.HRApp.models;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "candidats")
public class Candidature {
    @Id
    @GeneratedValue
    public Integer id;

    @Column(name="firstname",nullable=false)
    public String firstname;

    @Column(name="lastname",nullable=false)
    public String lastname;

    @Column(name="password",nullable=false)
    public String password;


    @Column(name="email",nullable = false,unique=true)
    public String email;

    @Column(name="phone")
    public Integer phone;

    @Column(name="cin")
    public Integer cin;

    @Column(name="adresse")
    public String adresse;

    @Column(name="ville")
    public String ville;

    @Column(name="pathCv")
    public String pathCv;

    @Column(name="dateOfBirth")
    public Date dateOfBirth;

    @Column(name="pathMotivationLetter")
    public String pathMotivationLetter;

    @Column(name="niveauEtud")
    public Integer niveauEtud;

    @Column(name="titreDiplome")
    public String titreDiplome;

    @Column(name="university")
    public String university;

    @Column(name="niveauExp")
    public Integer niveauExp;

    @Column(name="experience")
    public String experience;

    @Column(name="archived")
    public Boolean archived;
}
