package com.example.CabConnect.controller;

import com.example.CabConnect.dto.request.BookingRequest;
import com.example.CabConnect.dto.response.BookingResponse;
import com.example.CabConnect.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity bookCab(@RequestBody BookingRequest bookingRequest,@RequestParam(value = "coupon-applied",required = false)boolean couponApplied){
        try{
            BookingResponse response = bookingService.bookCab(bookingRequest,couponApplied);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    //Api to get random coupon from DB and apply discount to a customer
    //coupon boolean  value if it is true then apply coupon
    //it is optional
//    public ResponseEntity couponApplied(@RequestBody BookingRequest bookingRequest,@RequestParam(value = "coupon-applied", required = false) boolean couponApplied){
//
//    }

    //API find all the bookings done today use hoe to get current date and time in java

    //API to get top K highest fares bookings

    //API to get top K lowest fares bookings

    //API to get the customer with the highest fare booking

    //API to get the customer with the lowest fare booking


}
