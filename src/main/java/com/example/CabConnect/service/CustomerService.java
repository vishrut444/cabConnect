package com.example.CabConnect.service;

import com.example.CabConnect.Enum.Gender;
import com.example.CabConnect.Converter.CustomerConverter;
import com.example.CabConnect.dto.request.CustomerRequest;
import com.example.CabConnect.dto.response.CustomerResponse;
import com.example.CabConnect.exception.CustomerNotFoundException;
import com.example.CabConnect.model.Customer;
import com.example.CabConnect.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        //dto request -> model/entity
        Customer customer = CustomerConverter.customerRequestToCustomer(customerRequest);
        //save customer to DB
        Customer savedCustomer = customerRepository.save(customer);
        // model/entity -> dto response
        return CustomerConverter.customerToCustomerResponse(savedCustomer);
    }

    public CustomerResponse getCustomer(String email) {
        Optional<Customer> customer = Optional.ofNullable(customerRepository.findByEmailId(email));
        if(customer.isEmpty()) throw new CustomerNotFoundException("Customer is not registered!");

        Customer savedCustomer = customer.get();
        // model/entity -> dto response
        return  CustomerConverter.customerToCustomerResponse(savedCustomer);
    }

    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Customer> customers = customerRepository.getAllByGenderAndAgeGreaterThan(gender,age);
        //model -> response
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer:customers){
            customerResponses.add(CustomerConverter.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }
}
