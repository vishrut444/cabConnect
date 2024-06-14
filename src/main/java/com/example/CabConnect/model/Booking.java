package com.example.CabConnect.model;

import com.example.CabConnect.Enum.BookingStatus;
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
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String bookingId;// UUID

    @Column(nullable = false)//it cannot be null
    String pickup;

    @Column(nullable = false)
    String destination;

    BookingStatus bookingStatus;

    double totalDistanceTravelled;

    double totalFare;

    @CreationTimestamp
    Date bookedAt;

    @ManyToOne
    @JoinColumn//for PK
    Customer customer;

    @ManyToOne
    @JoinColumn
    Driver driver;

}
