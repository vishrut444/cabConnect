package com.example.CabConnect.model;

import com.example.CabConnect.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")//to change table name in DB
@Builder //to make object of this class just like new keyword
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Column(unique = true,nullable = false)//to make sure the email us unique and not null
    String emailId;

    @Enumerated(EnumType.STRING) //to store gender as string in db
    Gender gender;

    //mapping 1:M By directional relationship from Customer to Booking
    @OneToMany(mappedBy = "customer")
    List<Booking> bookings = new ArrayList<>();//we are using list as one customer can have many bookings
}
