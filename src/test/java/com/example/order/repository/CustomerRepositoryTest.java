package com.example.order.repository;

import com.example.order.exceptions.MemberAlreadyExistException;
import com.example.order.repository.DTO.CreateCustomerDTO;
import com.example.order.repository.users.Address;
import com.example.order.repository.users.Customer;
import com.example.order.repository.users.CustomerRepository;
import com.example.order.service.users.CustomerMapper;
import com.example.order.service.users.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerRepositoryTest {
    private CustomerRepository testCustomerRepository;
    private CustomerService testCustomerService;
    CustomerMapper testCustomerMapper;


    @BeforeEach
    void setUpCustomerRepository() {

        Customer customer1 = new Customer("John", "Doe", "john@email.com",
                new Address("Bakerstreet", "2", "1234", "Belgium"), "050234565", "john");
        Customer customer2 = new Customer("Hannah", "Lee", "hannah@email.com",
                new Address("Histreet", "32", "1234", "Belgium"), "050234565", "hannah");

        testCustomerRepository = new CustomerRepository();
        testCustomerMapper = new CustomerMapper();
        testCustomerService = new CustomerService(testCustomerRepository, testCustomerMapper);

        testCustomerRepository.addCustomer(customer1);
        testCustomerRepository.addCustomer(customer2);
    }

    @Test
    void givenNewCustomer_whenCustomerRegisters_newCustomerAddedToCustomerRepository (){
        Customer newCustomer = new Customer("Nancy", "Lee", "nancy@email.com",
                new Address("Histreet", "32", "1234", "Belgium"), "050234565", "hannah");

        testCustomerRepository.addCustomer(newCustomer);

        Assertions.assertTrue(testCustomerRepository.getCustomers().contains(newCustomer));
    }
    @Test
    void givenCustomerThatAlreadyExists_whenCustomerRegisters_exceptionThrownCustomerAlreadyExists (){
        CreateCustomerDTO newCustomer = new CreateCustomerDTO("John", "Doe", "john@email.com",
                new Address("Bakerstreet", "2", "1234", "Belgium"), "050234565", "john");

        Assertions.assertThrows(MemberAlreadyExistException.class, () -> testCustomerService.createCustomer(newCustomer));
    }


}