package com.example.hacknsu4_trafficapp.Repositories;

import com.example.hacknsu4_trafficapp.Models.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusRepo extends JpaRepository<Bus,Long> {

    @Query(value = "from Bus where busNumber = ?1")
    Bus findBus(String busName);
}
