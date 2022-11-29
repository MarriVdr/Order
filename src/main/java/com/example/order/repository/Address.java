package com.example.order.repository;

public class Address{
        private String streetName;
        private String streetNumber;
        private String postalCode;
        private String country;

    public Address(String streetName, String streetNumber, String postalCode, String country) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }
}
