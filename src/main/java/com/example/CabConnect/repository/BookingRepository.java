package com.example.CabConnect.repository;

import com.example.CabConnect.model.Booking;
import com.example.CabConnect.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

}
