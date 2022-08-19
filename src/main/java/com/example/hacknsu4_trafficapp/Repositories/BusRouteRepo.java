package com.example.hacknsu4_trafficapp.Repositories;

import com.example.hacknsu4_trafficapp.Models.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusRouteRepo extends JpaRepository<Route,Long> {

    @Query(value = "from Route where BusRoute like %?1% and BusRoute like %?2% ")
    List<Route> findBus(String location, String destination);

}
