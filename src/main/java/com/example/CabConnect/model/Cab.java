package com.example.CabConnect.model;

import com.example.CabConnect.Enum.CabType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cab")
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String cabNumber;

    @Enumerated(value = EnumType.STRING)
    private CabType cabType;

    private double farePerKm;

    private boolean booked;//if cab is booked or not


}
