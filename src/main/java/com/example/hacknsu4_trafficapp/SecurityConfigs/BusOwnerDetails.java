package com.example.hacknsu4_trafficapp.SecurityConfigs;

import com.example.hacknsu4_trafficapp.Models.BusOwner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class BusOwnerDetails implements UserDetails {


    private BusOwner busOwner;

    public BusOwnerDetails(BusOwner busOwner) {
        this.busOwner = busOwner;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public String getPassword() {
        return busOwner.getBusOwnerPass();
    }

    @Override
    public String getUsername() {
        return busOwner.getBusOwnerEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
