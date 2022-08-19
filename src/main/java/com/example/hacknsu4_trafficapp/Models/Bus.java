package com.example.hacknsu4_trafficapp.Models;

import javax.persistence.*;

@Entity
@Table(name = "Bus_Details")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long bus_id;
    @Column(nullable = false)
    private String busName;
    @Column(nullable = false, unique = true)
    private String busNumber;
    @Column(nullable = false)
    private String busDriver;
    private String busHelper;
    private String ownerName;

    public Bus(String busName, String busNumber, String busDriver, String busHelper, String ownerName) {
        this.busName = busName;
        this.busNumber = busNumber;
        this.busDriver = busDriver;
        this.busHelper = busHelper;
        this.ownerName = ownerName;
    }

    public Bus() {
    }

    public long getBus_id() {
        return bus_id;
    }

    public void setBus_id(long bus_id) {
        this.bus_id = bus_id;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getBusDriver() {
        return busDriver;
    }

    public void setBusDriver(String busDriver) {
        this.busDriver = busDriver;
    }

    public String getBusHelper() {
        return busHelper;
    }

    public void setBusHelper(String busHelper) {
        this.busHelper = busHelper;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "bus_id=" + bus_id +
                ", busName='" + busName + '\'' +
                ", busNumber='" + busNumber + '\'' +
                ", busDriver='" + busDriver + '\'' +
                ", busHelper='" + busHelper + '\'' +
                '}';
    }
}
