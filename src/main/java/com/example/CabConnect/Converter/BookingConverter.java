package com.example.CabConnect.Converter;


import com.example.CabConnect.Enum.BookingStatus;
import com.example.CabConnect.dto.request.BookingRequest;
import com.example.CabConnect.dto.response.BookingResponse;
import com.example.CabConnect.model.Booking;
import com.example.CabConnect.model.Cab;

import java.util.UUID;

public class BookingConverter {

    public static Booking bookingRequestToBooking(BookingRequest bookingRequest, Cab cab){
        return Booking.builder()
                .bookingId(String.valueOf(UUID.randomUUID()))
                .pickup(bookingRequest.getPickup())
                .destination(bookingRequest.getDestination())
                .bookingStatus(BookingStatus.CONFIRMED)
                .totalDistance(bookingRequest.getTotalDistance())
                .totalFare(bookingRequest.getTotalDistance() * cab.getFarePerKm())
                .build();
    }

    public static BookingResponse bookingToBookingResponse(Booking booking){
        return BookingResponse.builder()
                .bookingId(booking.getBookingId())
                .pickup(booking.getPickup())
                .destination(booking.getDestination())
                .bookingStatus(booking.getBookingStatus())
                .totalDistance(booking.getTotalDistance())
                .totalFare(booking.getTotalFare())
                .bookedAt(booking.getBookedAt())
                .customerResponse(CustomerConverter.customerToCustomerResponse(booking.getCustomer()))
                .driverResponse(DriverConverter.driverToDriverResponse(booking.getDriver()))
                .build();
    }
}
