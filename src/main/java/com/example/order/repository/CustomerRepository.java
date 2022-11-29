package com.example.order.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerRepository {
    private List<Customer> customers;

    public CustomerRepository(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
