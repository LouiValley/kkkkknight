package info.smartkit.shiny.guide.domain.vo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //User part
    @Column(name = "msno") //must same excel header (first row)
    private String msno;

    @Column(name = "city") //must same excel header (first row)0,1,2....
    private String city;

    @Column(name = "bd") //must same excel header (first row)0,1,2....
    private String bd;

    @Column(name = "gender") //must same excel header (first row)0,1,2....
    private String gender;

    @Column(name = "registered_via") //must same excel header (first row)0,1,2....
    private String registered_via;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", msno='" + msno + '\'' +
                ", city=" + city +
                ", bd=" + bd +
                ", gender=" + gender +
                ", registered_via=" + registered_via +
                ", registration_init_time=" + registration_init_time +
                ", expiration_date=" + expiration_date +
                '}';
    }

    public Member() {
    }

    public Member(String msno, String city, String bd, String gender, String registered_via, String registration_init_time, String expiration_date) {

        this.msno = msno;
        this.city = city;
        this.bd = bd;
        this.gender = gender;
        this.registered_via = registered_via;
        this.registration_init_time = registration_init_time;
        this.expiration_date = expiration_date;
    }

    @Column(name = "registration_init_time") //must same excel header (first row)0,1,2....
    private String registration_init_time;

    public String getMsno() {
        return msno;
    }

    public void setMsno(String msno) {
        this.msno = msno;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegistered_via() {
        return registered_via;
    }

    public void setRegistered_via(String registered_via) {
        this.registered_via = registered_via;
    }

    public String getRegistration_init_time() {
        return registration_init_time;
    }

    public void setRegistration_init_time(String registration_init_time) {
        this.registration_init_time = registration_init_time;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    @Column(name = "expiration_date") //must same excel header (first row)0,1,2....
    private String expiration_date;

}
