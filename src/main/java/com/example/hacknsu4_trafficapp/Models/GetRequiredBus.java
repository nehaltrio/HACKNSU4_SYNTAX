package com.example.hacknsu4_trafficapp.Models;

public class GetRequiredBus {
    public String location;
    public String destination;

    public GetRequiredBus(String location, String destination) {
        super();
        this.location = location;
        this.destination = destination;
    }

    public GetRequiredBus() {
        super();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

}
