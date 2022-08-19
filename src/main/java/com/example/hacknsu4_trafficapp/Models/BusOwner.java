package com.example.hacknsu4_trafficapp.Models;

import com.example.hacknsu4_trafficapp.UserRoles.Role;

import javax.persistence.*;

@Entity
@Table(name = "Bus_Owner_Details")
public class BusOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long busOwner_id;
    @Column(nullable = false , unique = true)
    private String busName;
    @Column(nullable = false)
    private String busOwnerName;
    @Column(nullable = false, unique = true)
    private String busOwnerNid;
    @Column(nullable = false, unique = true)
    private String busOwnerEmail;
    @Column(nullable = false)
    private String busOwnerPass;


    public BusOwner(String busName, String busOwnerName, String busOwnerNid, String busOwnerEmail, String busOwnerPass) {
        this.busName = busName;
        this.busOwnerName = busOwnerName;
        this.busOwnerNid = busOwnerNid;
        this.busOwnerEmail = busOwnerEmail;
        this.busOwnerPass = busOwnerPass;
    }


    public BusOwner() {
        super();
    }

    public Long getBusOwner_id() {
        return busOwner_id;
    }

    public void setBusOwner_id(Long busOwner_id) {
        this.busOwner_id = busOwner_id;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusOwnerName() {
        return busOwnerName;
    }

    public void setBusOwnerName(String busOwnerName) {
        this.busOwnerName = busOwnerName;
    }

    public String getBusOwnerNid() {
        return busOwnerNid;
    }

    public void setBusOwnerNid(String busOwnerNid) {
        this.busOwnerNid = busOwnerNid;
    }

    public String getBusOwnerEmail() {
        return busOwnerEmail;
    }

    public void setBusOwnerEmail(String busOwnerEmail) {
        this.busOwnerEmail = busOwnerEmail;
    }

    public String getBusOwnerPass() {
        return busOwnerPass;
    }

    public void setBusOwnerPass(String busOwnerPass) {
        this.busOwnerPass = busOwnerPass;
    }
}
