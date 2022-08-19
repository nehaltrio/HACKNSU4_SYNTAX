package com.example.hacknsu4_trafficapp.Repositories;

import com.example.hacknsu4_trafficapp.Models.BusInfoQRcode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusQrRepo extends JpaRepository<BusInfoQRcode, Long> {
}
