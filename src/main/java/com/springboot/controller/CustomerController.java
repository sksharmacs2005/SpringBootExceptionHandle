package com.springboot.controller;

import com.springboot.exception.NoSuchCustomerExistsException;
import com.springboot.model.Customer;
import com.springboot.service.CustomerService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Get Customer by Id
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) throws NoSuchCustomerExistsException {
        Customer customerId = customerService.getCustomer(id);
        return ResponseEntity.ok(customerId);
    }

    // Add new Customer
    @PostMapping
    public ResponseEntity<String> addcustomer(@Valid @RequestBody Customer customer) {
        String cust = customerService.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(cust);
    }

    // Update Customer details    @PutMapping("/updateCustomer")
    public String
    updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }
}