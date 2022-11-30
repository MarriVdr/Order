package com.example.order.repository.users;

public class Admin {
    private Role adminRoll = Role.ADMIN;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Admin(String firstName, String lastName, String email, String password) {
        this.adminRoll = adminRoll;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
