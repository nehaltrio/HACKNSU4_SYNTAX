package com.example.hacknsu4_trafficapp.Models;

import com.example.hacknsu4_trafficapp.UserRoles.Role;

import javax.persistence.*;

@Entity
@Table(name = "Passenger_Details")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long passenger_id;
    @Column(nullable = false)
    private String passenger_name;
    @Column(nullable = false, unique = true)
    private String passenger_NID;
    @Column(nullable = false, unique = true)
    private String passenger_email;
    @Column(nullable = false)
    private String passenger_pass;


    public Passenger(String passenger_name, String passenger_NID, String passenger_email, String passenger_pass) {
        this.passenger_name = passenger_name;
        this.passenger_NID = passenger_NID;
        this.passenger_email = passenger_email;
        this.passenger_pass = passenger_pass;
    }

    public Passenger() {
        super();
    }




    public Long getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(Long passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public String getPassenger_NID() {
        return passenger_NID;
    }

    public void setPassenger_NID(String passenger_NID) {
        this.passenger_NID = passenger_NID;
    }

    public String getPassenger_email() {
        return passenger_email;
    }

    public void setPassenger_email(String passenger_email) {
        this.passenger_email = passenger_email;
    }

    public String getPassenger_pass() {
        return passenger_pass;
    }

    public void setPassenger_pass(String passenger_pass) {
        this.passenger_pass = passenger_pass;
    }
}
