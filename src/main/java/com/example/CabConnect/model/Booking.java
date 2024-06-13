package com.example.CabConnect.model;

import com.example.CabConnect.Enum.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bookingId;// UUID

    @Column(nullable = false)//it cannot be null
    private String pickup;

    @Column(nullable = false)
    private String destination;

    private BookingStatus bookingStatus;

    private double totalDistanceTravelled;

    private double totalFare;

    @CreationTimestamp
    private Date bookedAt;

}
