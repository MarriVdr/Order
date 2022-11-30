package com.example.order.service.users;

import com.example.order.exceptions.FieldIsEmptyException;
import com.example.order.exceptions.IdDoesNotExistsException;
import com.example.order.exceptions.MemberAlreadyExistException;
import com.example.order.repository.DTO.CustomerDTO;
import com.example.order.repository.DTO.ItemDTO;
import com.example.order.repository.users.Customer;
import com.example.order.repository.users.CustomerRepository;
import com.example.order.repository.DTO.CreateCustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public String createCustomer(CreateCustomerDTO customerToCreate) {
        if (customerToCreate.getEmail() == null) {
            throw new FieldIsEmptyException("Please enter a valid email.");
        }
        if (customerRepository.containsCustomer(customerToCreate.getEmail())) {
            throw new MemberAlreadyExistException("Member already exists.");
        }
        Customer customer = customerMapper.mapToCustomer(customerToCreate);
        customerRepository.addCustomer(customer);
        return "Registration successful.";
    }

    public List<CustomerDTO> getListOfCustomers() {
        return customerMapper.toDTO(customerRepository.getCustomers());
    }

    public CustomerDTO getCustomerById(String id) {
        return customerMapper.toDTO(customerRepository.findCustomerById(id).orElseThrow(() -> new IdDoesNotExistsException("Customer id not found.")));
    }


}
