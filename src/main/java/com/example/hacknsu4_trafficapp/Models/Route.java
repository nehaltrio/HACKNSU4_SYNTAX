package com.example.hacknsu4_trafficapp.Models;

import javax.persistence.*;

@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long busRoute_id;
    @Column(name = "bus_name", nullable = false)
    private String BusName;
    @Column(name = "bus_route", nullable = false, columnDefinition = "TEXT")
    private String BusRoute;

    public Route(Long busRoute_id, String busName, String busRoute) {
        super();
        this.busRoute_id = busRoute_id;
        BusName = busName;
        BusRoute = busRoute;
    }

    public Route() {
        super();
    }

    public Route(String busName, String busRoute) {
        BusName = busName;
        BusRoute = busRoute;
    }

    public Long getBusRoute_id() {
        return busRoute_id;
    }

    public void setBusRoute_id(Long busRoute_id) {
        this.busRoute_id = busRoute_id;
    }

    public String getBusName() {
        return BusName;
    }

    public void setBusName(String busName) {
        BusName = busName;
    }

    public String getBusRoute() {
        return BusRoute;
    }

    public void setBusRoute(String busRoute) {
        BusRoute = busRoute;
    }

    @Override
    public String toString() {
        return "Route{" +
                "busRoute_id=" + busRoute_id +
                ", BusName='" + BusName + '\'' +
                ", BusRoute='" + BusRoute + '\'' +
                '}';
    }
}
