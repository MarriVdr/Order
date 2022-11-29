package com.example.order.API;

import com.example.order.repository.DTO.CreateCustomerDTO;
import com.example.order.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eurder")
public class EurderController {
private CustomerService customerService;

    public EurderController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/registerCustomer")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CreateCustomerDTO customerToCreate) {
        customerService.createCustomer(customerToCreate);
    }


}
