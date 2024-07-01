package com.example.CabConnect.model;

import com.example.CabConnect.Enum.BookingStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "booking")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    //we will set up at backend
    String bookingId;// UUID

    @Column(nullable = false)//it cannot be null
    String pickup;

    @Column(nullable = false)
    String destination;

    //set at the backend
    @Enumerated(EnumType.STRING)
    BookingStatus bookingStatus;

    //we will take it from client,
    //but actually it is calculated by Google Maps
    double totalDistance;

    //we will calculate at backend
    double totalFare;

    @CreationTimestamp
    Date bookedAt;

    @ManyToOne
    @JoinColumn//for PK
    @JsonIgnore
    Customer customer;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Driver driver;

}
