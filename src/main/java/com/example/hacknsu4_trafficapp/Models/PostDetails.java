package com.example.hacknsu4_trafficapp.Models;

import javax.persistence.*;

@Entity
public class PostDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String user_name;
    public String busName;
    @Column(columnDefinition = "TEXT")
    public String feedback;

    public PostDetails(String user_name, String busName, String feedback) {
        this.user_name = user_name;
        this.busName = busName;
        this.feedback = feedback;
    }

    public PostDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
