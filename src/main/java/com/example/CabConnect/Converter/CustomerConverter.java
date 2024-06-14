package com.example.CabConnect.Converter;

import com.example.CabConnect.dto.request.CustomerRequest;
import com.example.CabConnect.dto.response.CustomerResponse;
import com.example.CabConnect.model.Customer;

public class CustomerConverter {

    // dto -> model
    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
//        Customer customer = new Customer();
//        customer.setName(customerRequest.getName());
//        customer.setAge(customerRequest.getAge());
//        customer.setGender(customerRequest.getGender());
//        customer.setEmailId(customerRequest.getEmailId());
//        return customer;

        //the above code can be written in one line using Builder
        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .gender(customerRequest.getGender())
                .emailId(customerRequest.getEmailId())
                .build();

    }

    // model -> dto
    public static CustomerResponse customerToCustomerResponse(Customer customer){
//        CustomerResponse customerResponse = new CustomerResponse();
//        customerResponse.setName(customer.getName());
//        customerResponse.setAge(customer.getAge());
//        customerResponse.setEmailId(customerResponse.getEmailId());
//        return customerResponse;

        return CustomerResponse.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .emailId(customer.getEmailId())
                .build();
    }
}
