package com.customermgmt.service;

import com.customermgmt.domain.Customer;
import com.customermgmt.exceptions.CustomerNotFoundException;
import com.customermgmt.exceptions.InsufficientTextException;
import com.customermgmt.exceptions.InvalidIdException;
import com.customermgmt.exceptions.InvalidInputException;

import java.util.List;

public interface ICustomerService {
    Customer register(String firstName, String lastName) throws InvalidInputException;
    Customer findById(Integer id) throws InvalidIdException, CustomerNotFoundException;
    List<Customer> findCustomersByFirstNameAscendingId(String firstName) throws InsufficientTextException, CustomerNotFoundException;
}
