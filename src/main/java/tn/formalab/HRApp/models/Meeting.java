package tn.formalab.HRApp.models;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "meetings")
public class Meeting {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(name="titre")
    public String titre;

    @Column(name="type")
    public String type;

    @Column(name="meetingDay")
    public Date meetingDay;

    @Column(name="meetingTime")
    public Date meetingTime;

    @Column(name="canceled")
    public Boolean canceled;
}
