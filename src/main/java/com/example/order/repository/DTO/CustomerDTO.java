package com.example.order.repository.DTO;

import com.example.order.repository.Address;

import java.util.UUID;

public class CustomerDTO {
    private final String customerId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Address address;
    private final String phoneNumber;

    public CustomerDTO(String customerId, String firstName, String lastName, String email, Address address, String phoneNumber) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = new Address(address.getStreetName(), address.getStreetNumber(), address.getPostalCode(), address.getCountry());
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCustomerId() {
        return customerId;
    }
}
