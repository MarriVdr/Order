package com.example.order.API;

import com.example.order.exceptions.MemberAlreadyExistException;
import com.example.order.repository.DTO.CreateCustomerDTO;
import com.example.order.repository.DTO.CustomerDTO;
import com.example.order.repository.users.Address;
import com.example.order.repository.users.CustomerRepository;
import com.example.order.service.users.CustomerService;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import io.restassured.RestAssured;

import static io.restassured.http.ContentType.JSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;


    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Test
    void givenNewCustomer_whenCustomerRegister_CustomerCanOnlyRegisterOnce(){
        CreateCustomerDTO expectedCustomer = new CreateCustomerDTO("John", "Doe", "john@email.com",
                new Address("Bakerstreet", "2", "1234", "Belgium"), "050234565", "password");
        CreateCustomerDTO sameCustomer = new CreateCustomerDTO("John", "Doe", "john@email.com",
                new Address("Bakerstreet", "2", "1234", "Belgium"), "050234565", "password");

        CustomerDTO createdCustomer = customerService.createCustomer(expectedCustomer);



        RestAssured
                .given()
                .contentType(JSON)
                .accept(JSON)
                .when()
                .port(port)
                .body(sameCustomer)
                .post("/eurder/customers/")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);

        Assertions.assertThrows(MemberAlreadyExistException.class, () -> customerService.createCustomer(sameCustomer));
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Test

    void givenAdmin_whenGettingCustomerById_returnCorrectCustomer() {
        CreateCustomerDTO expectedCustomer = new CreateCustomerDTO("John", "Doe", "john@email.com",
                new Address("Bakerstreet", "2", "1234", "Belgium"), "050234565", "password");


        CustomerDTO createdCustomer = customerService.createCustomer(expectedCustomer);

        CustomerDTO customerDTO = RestAssured
                .given()
                .accept(JSON)
                .when()
                .port(port)
                .get("/eurder/customers/" + createdCustomer.getCustomerId())
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(CustomerDTO.class);

        Assertions.assertEquals(expectedCustomer.getEmail(), customerDTO.getEmail());
    }


}