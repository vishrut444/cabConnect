package com.example.CabConnect.repository;

import com.example.CabConnect.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findByEmailId(String email);

    //writing your own query
    @Query(value = "SELECT * FROM customer WHERE gender = :gender AND age >= :age",nativeQuery = true)
    public List<Customer> getAllByGenderAndAgeGreaterThan(String gender,int age);

}

