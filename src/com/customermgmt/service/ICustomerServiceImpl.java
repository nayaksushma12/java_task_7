package com.customermgmt.service;

import com.customermgmt.domain.Customer;
import com.customermgmt.exceptions.CustomerNotFoundException;
import com.customermgmt.exceptions.InsufficientTextException;
import com.customermgmt.exceptions.InvalidIdException;
import com.customermgmt.exceptions.InvalidInputException;

import java.util.*;

public class ICustomerServiceImpl implements ICustomerService {

    Map<Integer, Customer> store = new HashMap<>();
    private int generatedId;

    private int generateId() {
        return ++generatedId;
    }

    @Override
    public Customer register(String firstName, String lastName) throws InvalidInputException {
        validateName(firstName);
        validateName(lastName);
        int newId = generateId();
        Customer customer = new Customer(newId, firstName, lastName);
        store.put(newId, customer);
        return customer;
    }

    @Override
    public Customer findById(Integer id) throws InvalidIdException, CustomerNotFoundException {
        validateId(id);

        Customer customer = store.get(id);
        if (customer == null) throw new CustomerNotFoundException("Customer not found");
        return customer;


}

    @Override
    public List<Customer> findCustomersByFirstNameAscendingId(String search) throws CustomerNotFoundException, InsufficientTextException {
        validateSearch(search);
        List<Customer> customerList = new ArrayList<>();
        for(Customer customer: store.values()){
            if(customer.getFirstName().toLowerCase().startsWith(search.toLowerCase())){
                customerList.add(customer);
            }
        }

        if (customerList.isEmpty()) throw new CustomerNotFoundException("No customer found");
        customerList.sort(new IdKeyComparator());
        return customerList;
    }

    private void validateSearch(String firstName) throws InsufficientTextException {
        if (firstName.length() < 3) throw new InsufficientTextException("Insufficient text for search");
    }


    public void validateName(String name) throws InvalidInputException {
        if (name == null || name.length() < 2 || name.length() > 10) {
            throw new InvalidInputException("invalid input");
        }
    }

    public void validateId(Integer id) throws InvalidIdException, CustomerNotFoundException {
        if (id < 1) throw new InvalidIdException("invalid id");

    }


    public void display(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

}
