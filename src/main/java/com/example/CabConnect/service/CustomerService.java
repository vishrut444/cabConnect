package com.example.CabConnect.service;

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
        Customer customer = new Customer();
        customer.setAge(customerRequest.getAge());
        customer.setName(customerRequest.getName());
        customer.setEmailId(customerRequest.getEmailId());
        customer.setGender(customerRequest.getGender());

        //save customer to DB
        Customer savedCustomer = customerRepository.save(customer);

//        return "Customer added successfully";

        //make a response dto
        //model/entity -> dto response
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setName(savedCustomer.getName());
        customerResponse.setEmailId(savedCustomer.getEmailId());
        customerResponse.setAge(savedCustomer.getAge());

        return customerResponse;
    }

    public CustomerResponse getCustomer(String email) {
        Customer customer = customerRepository.findByEmailId(email);

        //model/entity -> dto response
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setEmailId(customer.getEmailId());
        customerResponse.setName(customer.getName());
        customerResponse.setAge(customer.getAge());
        return customerResponse;
    }

    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(String gender, int age) {
        List<Customer> customers = customerRepository.getAllByGenderAndAgeGreaterThan(gender,age);

        //model -> response
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer:customers){
            CustomerResponse customerResponse = new CustomerResponse();
            customerResponse.setName(customer.getName());
            customerResponse.setAge(customer.getAge());
            customerResponse.setEmailId(customer.getEmailId());
            customerResponses.add(customerResponse);
        }
        return customerResponses;
    }
}
