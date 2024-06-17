package com.example.CabConnect.controller;

import com.example.CabConnect.dto.request.DriverRequest;
import com.example.CabConnect.dto.response.DriverResponse;
import com.example.CabConnect.exception.DriverNotFound;
import com.example.CabConnect.model.Driver;
import com.example.CabConnect.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    //API to add driver details and cab: good practice make seperate apis for both and connect
    //for cascading we re making it in same
    @PostMapping
    public ResponseEntity addDriverAndCab(@RequestBody DriverRequest driverRequest){
        DriverResponse driver = driverService.addDriverAndCab(driverRequest);
        return new ResponseEntity(driver,HttpStatus.CREATED);
    }

    //API to get Driver
    @GetMapping("/mobileNo/{mob-no}")
    public DriverResponse getDriver(@PathVariable("mob-no") long mobileNo){
        return driverService.getDriver(mobileNo);
    }

    //API to get all drivers above a particular age
    @GetMapping("/age/{age}")
    public List<DriverResponse> getAllDriverAboveParticularAge(@PathVariable("age") int age){
        return driverService.getAllDriverAboveParticularAge(age);
    }

    //API to get Driver with max number of booking

    //API to update driver license no
    @PutMapping("/mobileNo/{mob-no}/NewLicense/{newlicenseNo}")
    public ResponseEntity updateLicense(@PathVariable("mob-no") int mobileNo,@PathVariable("newlicenseNo") String newLicense){
        DriverResponse updatedDriver = driverService.updateLicense(mobileNo,newLicense);
        return new ResponseEntity(updatedDriver,HttpStatus.CREATED);
    }

    //API update mob no
    @PutMapping
    public ResponseEntity updateMobile(@RequestParam("old-mob") long Omob,@RequestParam("new-mob") long Nmob){
        try {
            DriverResponse updateDriver = driverService.updateMobile(Omob,Nmob);
            return new ResponseEntity(updateDriver,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    //API delete driver with mob-no

    //API with driver with the least no of Bookings

    //API to get all drivers with less than 10 bookings

}
