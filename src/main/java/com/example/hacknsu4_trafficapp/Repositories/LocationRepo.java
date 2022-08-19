package com.example.hacknsu4_trafficapp.Repositories;

import com.example.hacknsu4_trafficapp.Models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location, Long> {
}
