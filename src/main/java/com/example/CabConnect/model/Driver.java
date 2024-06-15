package com.example.CabConnect.model;

import com.example.CabConnect.Enum.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "driver")
@FieldDefaults(level = AccessLevel.PRIVATE)//to change the accessmodifier of all methods and fun in the class
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "full_name")
    String name;

    //it will remain public as @FieldDefaults have the lowest level of precedence
    //public int age;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(unique = true,nullable = false)
    String drivingLicense;

    long mobileNo;

    //one to one bidirectional mapping
    //we write driver which is Driver variable in Cab entity
    //so that hibernate can understand that this Driver entity is related to Cab entity
    //we write mappedBy in the Parent entity generally this completes a By-directional relationship
    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    @JsonIgnore //to prevent Jackson infinite problem this annotation is under jackson class
    //it is like a breaking point
    //while deserialization simply ignore below cab
    Cab cab;

    //mapping Driver to Booking
    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Booking> bookings = new ArrayList<>(); //always initialize a list to avoid null ptr exception
}
