package com.example.CabConnect.repository;

import com.example.CabConnect.model.Driver;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {

    Driver findByMobileNo(long mobileNo);

    @Query(value = "SELECT d FROM Driver d WHERE d.age > :age")
    List<Driver> getAllDriverAboveParticularAge(int age);

    @Modifying
    @Transactional//so that update occurs in one transaction
    @Query(value = "UPDATE Driver d SET d.drivingLicense = :newLicense WHERE d.mobileNo = :mobileNo")
    void updateLicense(int mobileNo, String newLicense);


    @Modifying
    @Transactional
    @Query(value = "UPDATE Driver d SET d.mobileNo = :nmob WHERE d.mobileNo = :omob")
    void updateMobile(long omob, long nmob);
}
