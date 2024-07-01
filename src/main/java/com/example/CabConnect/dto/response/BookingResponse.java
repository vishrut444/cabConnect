package com.example.CabConnect.dto.response;

import com.example.CabConnect.Enum.BookingStatus;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {

    String bookingId;// UUID

    String pickup;

    String destination;

    BookingStatus bookingStatus;

    double totalDistance;

    double totalFare;

    Date bookedAt;

    CustomerResponse customerResponse;

    DriverResponse driverResponse;

}
