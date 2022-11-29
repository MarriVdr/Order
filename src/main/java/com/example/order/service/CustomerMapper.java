package com.example.order.service;

import com.example.order.repository.Address;
import com.example.order.repository.Customer;
import com.example.order.repository.DTO.CreateCustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {



    public Customer mapToCustomer(CreateCustomerDTO customerToCreate) {
        return new Customer(customerToCreate.getFirstName(), customerToCreate.getLastName(), customerToCreate.getEmail(), customerToCreate.getAddress(), customerToCreate.getPhoneNumber());
    }

}
