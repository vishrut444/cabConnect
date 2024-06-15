package com.example.CabConnect.dto.response;

import com.example.CabConnect.Enum.Gender;
import com.example.CabConnect.model.Cab;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DriverResponse {

    String name;

    Gender gender;

    long mobileNo;

    //which cab driver is riding
    //Cab cab;
    CabResponse cabResponse;

}
