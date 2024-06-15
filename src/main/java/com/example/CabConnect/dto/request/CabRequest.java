package com.example.CabConnect.dto.request;

import com.example.CabConnect.Enum.CabType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CabRequest {

    String cabNumber;

    CabType cabType;

    double farePerKm;
}
