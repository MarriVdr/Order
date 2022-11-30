package com.example.order.repository.users;

import com.example.order.repository.items.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class CustomerRepository {
    private List<Customer> customers;

    public CustomerRepository() {
        this.customers = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public boolean containsCustomer(String email) {
        return customers.stream().anyMatch(customer -> customer.getEmail().equals(email));
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Optional<Customer> findCustomerById(String id) {
        return customers.stream().filter(customer -> customer.getCustomerId().equals(id)).findFirst();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerRepository that = (CustomerRepository) o;
        return Objects.equals(customers, that.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customers);
    }
}
