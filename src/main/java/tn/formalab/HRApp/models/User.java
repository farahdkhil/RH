package tn.formalab.HRApp.models;
import javax.persistence.*;
@Entity
@Table(name="users")
public class User {
        @Id
        @GeneratedValue
        public Integer idUser;

        @Column(name="firstname",nullable=false)
        public String firstname;

        @Column(name="lastname",nullable=false)
        public String lastname;

        @Column(name="password",nullable=false)
        public String password;

        @Column(name="role")
        public String role="client";

        @Column(name="email",nullable = false,unique=true)
        public String email;

        @Column(name="accountState")
        public Boolean accountState = true;

}
