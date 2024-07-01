package com.example.CabConnect.repository;

import com.example.CabConnect.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CabRepository extends JpaRepository<Cab,Integer> {

    //randomly selecting an available cab
    @Query(value = "SELECT * FROM cab WHERE booked = 0 ORDER BY RAND() LIMIT 1",nativeQuery = true)
    Optional<Cab> getRandomAvailableCab();
}
