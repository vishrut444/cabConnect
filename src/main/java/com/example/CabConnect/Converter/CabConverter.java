package com.example.CabConnect.Converter;

import com.example.CabConnect.dto.request.CabRequest;
import com.example.CabConnect.dto.response.CabResponse;
import com.example.CabConnect.model.Cab;

public class CabConverter {

    public static Cab cabRequestToCab(CabRequest cabRequest){
        return Cab.builder()
                .cabNumber(cabRequest.getCabNumber())
                .cabType(cabRequest.getCabType())
                .farePerKm(cabRequest.getFarePerKm())
                .booked(false)//we will hard code booked as false as cab is not booked yet
                .build();
    }

    public static CabResponse cabToCabResponse(Cab cab){
        return CabResponse.builder()
                .booked(cab.isBooked())
                .cabNumber(cab.getCabNumber())
                .cabType(cab.getCabType())
                .farePerKm(cab.getFarePerKm())
                .build();
    }

}
