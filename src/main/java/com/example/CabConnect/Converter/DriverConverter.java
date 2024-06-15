package com.example.CabConnect.Converter;

import com.example.CabConnect.dto.request.DriverRequest;
import com.example.CabConnect.dto.response.DriverResponse;
import com.example.CabConnect.model.Driver;

public class DriverConverter {

    public static Driver driverRequesrToDriver(DriverRequest driverRequest){
        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .gender(driverRequest.getGender())
                .drivingLicense(driverRequest.getDrivingLicense())
                .mobileNo(driverRequest.getMobileNo())
                .build();
    }

    public static DriverResponse driverToDriverResponse(Driver driver){
        return DriverResponse.builder()
                .name(driver.getName())
                .gender(driver.getGender())
                .mobileNo(driver.getMobileNo())
                .cabResponse(CabConverter.cabToCabResponse(driver.getCab()))
                .build();
    }
}
