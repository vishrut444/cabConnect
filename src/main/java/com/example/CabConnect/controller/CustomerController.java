package com.example.CabConnect.controller;

import com.example.CabConnect.Enum.Gender;
import com.example.CabConnect.dto.request.CustomerRequest;
import com.example.CabConnect.dto.response.CustomerResponse;
import com.example.CabConnect.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

//    @Autowired
//    CustomerService customerService;
    private final CustomerService customerService;

    //API to add Customer details
    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.addCustomer(customerRequest);

        return new ResponseEntity(customerResponse, HttpStatus.CREATED);
    }

    //API to get customer detail
    //most logical by putting email ans it is unique and notnull
    @GetMapping
    public ResponseEntity getCustomer(@RequestParam("email") String email) {
        try{
            CustomerResponse customerResponse = customerService.getCustomer(email);
            return new ResponseEntity(customerResponse,HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/gender/{gender}/age/{age}")
    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(@PathVariable("gender") Gender gender, @PathVariable("age") int age) {
        return customerService.getAllByGenderAndAgeGreaterThan(gender,age);
    }


}
