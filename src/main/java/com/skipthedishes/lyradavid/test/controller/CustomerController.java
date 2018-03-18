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

    @PostMapping(value = "/api/v1/customer/auth", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> authCheck(@Valid @RequestBody AuthDto auth) {

        Customer customer = customerRepository.findCustomerEmail(auth.getEmail());

        if (customer !=null) {
            if (auth.getEmail() != null && auth.getPassword() != null) {
                if (customer.getEmail().equals(customer.getEmail()) && auth.getPassword().equals(customer.getPassword()))
                    return new ResponseEntity<Object>(HttpStatus.OK);
                else
                    return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
            }
        } else return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }



    @Data
    public static class AuthDto implements Serializable {
        @NotBlank
        private String email;
        @NotBlank
        private String password;
    }

}