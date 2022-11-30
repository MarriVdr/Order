package com.example.order.repository;

import com.example.order.exceptions.MemberAlreadyExistException;
import com.example.order.repository.DTO.CreateCustomerDTO;
import com.example.order.repository.DTO.CustomerDTO;
import com.example.order.repository.DTO.ItemDTO;
import com.example.order.repository.DTO.UpdateItemDTO;
import com.example.order.repository.items.Item;
import com.example.order.repository.users.Address;
import com.example.order.repository.users.Customer;
import com.example.order.repository.users.CustomerRepository;
import com.example.order.service.users.CustomerMapper;
import com.example.order.service.users.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomerRepositoryTest {
    private CustomerRepository testCustomerRepository;
    private CustomerService testCustomerService;
    private CustomerMapper testCustomerMapper;
    private Customer customer1;
    private Customer customer2;


    @BeforeEach
    void setUpCustomerRepository() {

        customer1 = new Customer("John", "Doe", "john@email.com",
                new Address("Bakerstreet", "2", "1234", "Belgium"), "050234565", "john");
        customer2 = new Customer("Hannah", "Lee", "hannah@email.com",
                new Address("Histreet", "32", "1234", "Belgium"), "050234565", "hannah");

        testCustomerRepository = new CustomerRepository();
        testCustomerMapper = new CustomerMapper();
        testCustomerService = new CustomerService(testCustomerRepository, testCustomerMapper);

        testCustomerRepository.addCustomer(customer1);
        testCustomerRepository.addCustomer(customer2);
    }

    @Test
    void givenNewCustomer_whenCustomerRegisters_newCustomerAddedToCustomerRepository() {
        Customer newCustomer = new Customer("Nancy", "Lee", "nancy@email.com",
                new Address("Histreet", "32", "1234", "Belgium"), "050234565", "hannah");

        testCustomerRepository.addCustomer(newCustomer);

        Assertions.assertTrue(testCustomerRepository.getCustomers().contains(newCustomer));
    }

    @Test
    void givenCustomerThatAlreadyExists_whenCustomerRegisters_exceptionThrownCustomerAlreadyExists() {
        CreateCustomerDTO newCustomer = new CreateCustomerDTO("John", "Doe", "john@email.com",
                new Address("Bakerstreet", "2", "1234", "Belgium"), "050234565", "john");

        Assertions.assertThrows(MemberAlreadyExistException.class, () -> testCustomerService.createCustomer(newCustomer));
    }

    @Test
    void givenListOfCustomers_whenGettingListOfAllCustomers_returnCorrectList() {
        List<Customer> expectedList = List.of(customer1, customer2);
        Assertions.assertTrue(testCustomerRepository.getCustomers().containsAll(expectedList));
    }

//    @Test
//    void givenCustomerId_returnRelevantCustomerInformation(){
//        String id = testCustomerRepository.getCustomers().get(0).getCustomerId();
//
//        CustomerDTO expectedCustomer = new CustomerDTO(testCustomerRepository.findCustomerById(id),"John", "Doe", "john@email.com",
//                new Address("Bakerstreet", "2", "1234", "Belgium"), "050234565");
//
//
//
//        CustomerDTO customer = testCustomerService.getCustomerById(id);
//
//        Assertions.assertEquals(expectedCustomer, customer);
//
//    }
}