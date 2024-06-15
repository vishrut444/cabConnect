package com.example.CabConnect.dto.request;

import com.example.CabConnect.Enum.Gender;
import com.example.CabConnect.model.Cab;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DriverRequest {

    String name;

    int age;

    Gender gender;

    String drivingLicense;

    long mobileNo;

    //this is not good take it as request
    //Cab cab;
    CabRequest cabRequest;
}
