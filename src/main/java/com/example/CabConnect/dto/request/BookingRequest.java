package com.example.CabConnect.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingRequest {

    String pickup;

    String destination;

    double totalDistance;

    //from Customer, we take email
    String customerEmail;


}
