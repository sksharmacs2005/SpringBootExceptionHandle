package com.springboot.service;

import com.springboot.exception.CustomerAlreadyExistsException;
import com.springboot.exception.NoSuchCustomerExistsException;
import com.springboot.model.Customer;
import com.springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRespository;

    // Method to get customer by Id.Throws
    // NoSuchElementException for invalid Id
    @Override
    public Customer getCustomer(Long id)
    {
        Optional<Customer> findById = customerRespository.findById(id);
        if (!findById.isPresent()) {
            throw new NoSuchCustomerExistsException(String.format("Customer not found with id %s", id));
        }
        return findById.get();
     }

    // Method to add new customer details to database.Throws
    // CustomerAlreadyExistsException when customer detail
    // already exist9
    @Override
    public String addCustomer(Customer customer)
    {
        Customer existingCustomer = customerRespository.findById(customer.getId())
                .orElse(null);
        if (existingCustomer == null) {
            customerRespository.save(customer);
            return "Customer added successfully";
        }
        else
            throw new CustomerAlreadyExistsException("Customer already exists!!");
    }

    // Method to update customer details to database.Throws
    // NoSuchCustomerExistsException when customer doesn't
    // already exist in database
    @Override
    public String updateCustomer(Customer customer)
    {
        Customer existingCustomer
                = customerRespository.findById(customer.getId())
                .orElse(null);
        if (existingCustomer == null)
            throw new NoSuchCustomerExistsException(
                    "No Such Customer exists!!");
        else {
            existingCustomer.setName(customer.getName());
            existingCustomer.setAddress(
                    customer.getAddress());
            customerRespository.save(existingCustomer);
            return "Record updated Successfully";
        }
    }
}