package com.example.CabConnect.repository;

import com.example.CabConnect.Enum.Gender;
import com.example.CabConnect.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findByEmailId(String email);

    //writing your own query
    //@Query(value = "SELECT * FROM customer WHERE gender = :gender AND age >= :age",nativeQuery = true)
    //public List<Customer> getAllByGenderAndAgeGreaterThan(String gender,int age);
    //corresponding HQL query for above and by default nativeQuery = false and in function we have to pass datatype correctly
    //And in every layer we have to take Gender as input
    @Query(value = "SELECT c FROM Customer c WHERE c.gender = :gender AND c.age>= :age")
    public List<Customer> getAllByGenderAndAgeGreaterThan(Gender gender, int age);

}

