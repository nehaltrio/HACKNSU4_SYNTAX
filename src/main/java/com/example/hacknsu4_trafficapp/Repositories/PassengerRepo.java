package com.example.hacknsu4_trafficapp.Repositories;

import com.example.hacknsu4_trafficapp.Models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface PassengerRepo extends JpaRepository<Passenger,Long> {

    @Query(value = "from Passenger where passenger_email = ?1")
    Passenger findPassenger(String email);

}

