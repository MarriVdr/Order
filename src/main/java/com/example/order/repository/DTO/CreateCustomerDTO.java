package com.example.order.repository.DTO;

import com.example.order.repository.users.Address;

public class CreateCustomerDTO {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Address address;
    private final String phoneNumber;
    private String password;

    public CreateCustomerDTO(String firstName, String lastName, String email, Address address, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = new Address(address.getStreetName(), address.getStreetNumber(), address.getPostalCode(), address.getCountry());
        this.phoneNumber = phoneNumber;
        this.password = password;
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

    public String getPassword() {
        return password;
    }
}
