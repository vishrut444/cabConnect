package com.example.CabConnect.controller;

import com.example.CabConnect.dto.request.CustomerRequest;
import com.example.CabConnect.dto.response.CustomerResponse;
import com.example.CabConnect.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    //API to add Customer details
    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.addCustomer(customerRequest);

        return new ResponseEntity(customerResponse, HttpStatus.CREATED);
    }

    //API to get customer detail
    //most logical by putting email ans it is unique and notnull
    @GetMapping("/get")
    public CustomerResponse getCustomer(@RequestParam("email") String email) {
        return customerService.getCustomer(email);
    }

    @GetMapping("/get-by-gender-age")
    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(@RequestParam("gender") String gender, @RequestParam("age") int age) {
        return customerService.getAllByGenderAndAgeGreaterThan(gender,age);
    }


}
