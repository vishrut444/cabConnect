package com.example.CabConnect.service;

import com.example.CabConnect.Converter.CabConverter;
import com.example.CabConnect.Converter.DriverConverter;
import com.example.CabConnect.dto.request.DriverRequest;
import com.example.CabConnect.dto.response.DriverResponse;
import com.example.CabConnect.model.Cab;
import com.example.CabConnect.model.Driver;
import com.example.CabConnect.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public DriverResponse addDriverAndCab(DriverRequest driverRequest) {
        //dto -> entity
        Driver driver = DriverConverter.driverRequesrToDriver(driverRequest);
        //cabReq -> cab dto
        Cab cab = CabConverter.cabRequestToCab(driverRequest.getCabRequest());

        //first go to Driver and Cab and check what parameters have to be set
        //these two lines are setting Bidirectional relationship
        driver.setCab(cab);
        cab.setDriver(driver);

        //save both driver and cab but due to cascade both will be saved
        driverRepository.save(driver);

        //driver -> response dto
        return DriverConverter.driverToDriverResponse(driver);

    }

    public DriverResponse getDriver(long mobileNo) {
        Driver savedDriver = driverRepository.findByMobileNo(mobileNo);
        //drive -> response
        return DriverConverter.driverToDriverResponse(savedDriver);
    }
}
