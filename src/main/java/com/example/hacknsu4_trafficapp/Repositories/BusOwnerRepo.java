package com.example.hacknsu4_trafficapp.Repositories;

import com.example.hacknsu4_trafficapp.Models.BusOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BusOwnerRepo extends JpaRepository<BusOwner, Long> {
    @Query(value = "from BusOwner where busOwnerEmail= ?1")
    BusOwner find_bus_owner(String email);
}
