package com.example.hacknsu4_trafficapp.Models;

import javax.persistence.*;

@Entity
public class BusInfoQRcode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(nullable = false, name = "qr_response")
    public String QRResponse;

    public BusInfoQRcode(Long id, String QRResponse) {
        this.id = id;
        this.QRResponse = QRResponse;
    }

    public BusInfoQRcode() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQRResponse() {
        return QRResponse;
    }

    public void setQRResponse(String QRResponse) {
        this.QRResponse = QRResponse;
    }
}
