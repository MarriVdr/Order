package com.example.order.service.users;

import com.example.order.repository.DTO.CustomerDTO;
import com.example.order.repository.users.Address;
import com.example.order.repository.users.Customer;
import com.example.order.repository.DTO.CreateCustomerDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMapper {



    public Customer mapToCustomer(CreateCustomerDTO customerToCreate) {
        return new Customer(customerToCreate.getFirstName(), customerToCreate.getLastName(), customerToCreate.getEmail(),
                customerToCreate.getAddress(), customerToCreate.getPhoneNumber(), customerToCreate.getPassword());
    }

    public CustomerDTO toDTO(Customer customer){
        return new CustomerDTO(customer.getCustomerId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(),
                new Address(customer.getAddress().getStreetName(), customer.getAddress().getStreetNumber(), customer.getAddress().getPostalCode(), customer.getAddress().getCountry()),
                customer.getPhoneNumber());
    }

    public List<CustomerDTO> toDTO(List<Customer> customers){
        return customers.stream()
                .map(this::toDTO)
                .toList();
    }

}
