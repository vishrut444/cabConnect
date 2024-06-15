package com.example.CabConnect.dto.response;

import com.example.CabConnect.Enum.CabType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CabResponse {

    String cabNumber;

    CabType cabType;

    double farePerKm;

    boolean booked;
}
