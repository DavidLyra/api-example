package com.skipthedishes.lyradavid.test.controller;

import com.skipthedishes.lyradavid.test.model.Customer;
import com.skipthedishes.lyradavid.test.repository.CustomerRepository;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.io.Serializable;

/**
 * Created by david on 17/03/2018.
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/api/v1/customer")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

}