package com.example.CabConnect.model;

import com.example.CabConnect.Enum.Gender;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "driver")
@FieldDefaults(level = AccessLevel.PRIVATE)//to change the accessmodifier of all methods and fun in the class
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "full_name")
    String name;

    //it will remain public as @FieldDefaults have lowest level of prcidence
    //public int age;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(unique = true,nullable = false)
    String drivingLicense;

    @Column(unique = true,nullable = false)
    long mobile;

    //one to one bidirectional mapping
    //we write driver which is Driver variable in Cab entity
    //so that hibernate can understand that this Driver entity is related to Cab entity
    //we write mappedBy in the Parent entity generally this completes a By-directional relationship
    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    Cab cab;

    //mapping Driver to Booking
    @OneToMany(mappedBy = "driver")
    List<Booking> bookings = new ArrayList<>(); //always initialize a list to avoid null ptr exception
}
