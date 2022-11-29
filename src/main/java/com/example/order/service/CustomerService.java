package com.example.order.service;

import com.example.order.repository.Customer;
import com.example.order.repository.CustomerRepository;
import com.example.order.repository.DTO.CreateCustomerDTO;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public void createCustomer(CreateCustomerDTO customerToCreate) {
        Customer customer = customerMapper.mapToCustomer(customerToCreate);
        customerRepository.addCustomer(customer);
    }


}
