package com.example.CabConnect.service;

import com.example.CabConnect.Converter.CabConverter;
import com.example.CabConnect.Converter.DriverConverter;
import com.example.CabConnect.dto.request.DriverRequest;
import com.example.CabConnect.dto.response.DriverResponse;
import com.example.CabConnect.exception.DriverNotFound;
import com.example.CabConnect.model.Cab;
import com.example.CabConnect.model.Driver;
import com.example.CabConnect.repository.DriverRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<DriverResponse> getAllDriverAboveParticularAge(int age) {
        List<Driver> drivers = driverRepository.getAllDriverAboveParticularAge(age);
        //converting drivers -> response
        List<DriverResponse> driverResponses = new ArrayList<>();
        for(Driver driver:drivers){
            driverResponses.add(DriverConverter.driverToDriverResponse(driver));
        }
        return driverResponses;
    }

//    @Transactional
    public DriverResponse updateLicense(int mobileNo, String newLicense) {
        driverRepository.updateLicense(mobileNo,newLicense);
        Driver driver = driverRepository.findByMobileNo(mobileNo);
        //driver -> dto response
        return DriverConverter.driverToDriverResponse(driver);
    }

    public DriverResponse updateMobile(long omob, long nmob) {
        Optional<Driver> optionalDriver = Optional.ofNullable(driverRepository.findByMobileNo(omob));
        if(optionalDriver.isEmpty()){
            throw new DriverNotFound("There is no Driver registered by the given Mobile Number!");
        }

        driverRepository.updateMobile(omob,nmob);
        Driver updatedDriver = driverRepository.findByMobileNo(nmob);
        //entity -> dto
        return DriverConverter.driverToDriverResponse(updatedDriver);

    }
}
