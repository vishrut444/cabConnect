package com.example.CabConnect.service;

import com.example.CabConnect.Enum.Gender;
import com.example.CabConnect.Transformer.CustomerTransformer;
import com.example.CabConnect.dto.request.CustomerRequest;
import com.example.CabConnect.dto.response.CustomerResponse;
import com.example.CabConnect.model.Customer;
import com.example.CabConnect.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        //dto request -> model/entity
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        //save customer to DB
        Customer savedCustomer = customerRepository.save(customer);
        // model/entity -> dto response
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public CustomerResponse getCustomer(String email) {
        Customer customer = customerRepository.findByEmailId(email);
        // model/entity -> dto response
        return  CustomerTransformer.customerToCustomerResponse(customer);
    }

    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Customer> customers = customerRepository.getAllByGenderAndAgeGreaterThan(gender,age);
        //model -> response
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer:customers){
            //CustomerResponse customerResponse = CustomerTransformer.customerToCustomerResponse(customer);
            //customerResponses.add(customerResponse);
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }
}
