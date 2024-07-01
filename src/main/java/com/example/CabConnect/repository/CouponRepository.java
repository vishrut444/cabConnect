package com.example.CabConnect.repository;

import com.example.CabConnect.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Integer> {

    @Query(value = "SELECT * FROM coupon WHERE is_applicable = 1 ORDER BY RAND() LIMIT 1",nativeQuery = true)
    Optional<Coupon> getRandomAvailableCoupon();
}
