package com.example.hacknsu4_trafficapp.SecurityConfigs;


import com.example.hacknsu4_trafficapp.Models.Bus;
import com.example.hacknsu4_trafficapp.Models.BusOwner;
import com.example.hacknsu4_trafficapp.Repositories.BusOwnerRepo;
import com.example.hacknsu4_trafficapp.SecurityConfigs.BusOwnerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BusOwnerDetailsService implements UserDetailsService {

    @Autowired
    BusOwnerRepo busOwnerRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BusOwner busOwner = busOwnerRepo.find_bus_owner(username);
        if (busOwner == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new BusOwnerDetails(busOwner);
    }
}
