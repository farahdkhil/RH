package tn.formalab.HRApp.models;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "todo")
public class ToDo {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(name="titre")
    public String titre;

    @Column(name="description")
    public String description;

    @Column(name="time")
    public Date time;

    @Column(name="completed")
    public Bool completed;
}
