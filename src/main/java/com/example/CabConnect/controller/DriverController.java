package com.example.CabConnect.controller;

import com.example.CabConnect.dto.request.DriverRequest;
import com.example.CabConnect.dto.response.DriverResponse;
import com.example.CabConnect.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    //API to get driver above a particular age

}
