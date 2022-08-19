package com.example.hacknsu4_trafficapp.Repositories;

import com.example.hacknsu4_trafficapp.Models.PostDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostDetailsRepo extends JpaRepository<PostDetails, Long> {

    @Override
    List<PostDetails> findAll();
}
