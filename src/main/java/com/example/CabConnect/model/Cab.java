package com.example.CabConnect.model;

import com.example.CabConnect.Enum.CabType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cab")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true,nullable = false)
    String cabNumber;

    @Enumerated(value = EnumType.STRING)
    CabType cabType;

    double farePerKm;

    boolean booked;//if cab is booked or not

    @OneToOne
    @JoinColumn
    Driver driver;


}
