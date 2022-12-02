package com.example.order.API;

import com.example.order.repository.DTO.CreateCustomerDTO;
import com.example.order.repository.DTO.CustomerDTO;
import com.example.order.service.users.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("eurder/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomer(@RequestBody CreateCustomerDTO customerToCreate) {
        return customerService.createCustomer(customerToCreate);
    }

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getListOfAllCustomers(){
        return customerService.getListOfCustomers();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO findCustomerById(@PathVariable String id){
        return customerService.getCustomerById(id);
    }
}
