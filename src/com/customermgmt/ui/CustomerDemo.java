package com.customermgmt.ui;

import com.customermgmt.domain.Customer;
import com.customermgmt.exceptions.CustomerNotFoundException;
import com.customermgmt.exceptions.InsufficientTextException;
import com.customermgmt.exceptions.InvalidIdException;
import com.customermgmt.exceptions.InvalidInputException;
import com.customermgmt.service.ICustomerService;
import com.customermgmt.service.ICustomerServiceImpl;

import java.util.List;
import java.util.Optional;

public class CustomerDemo {
    ICustomerServiceImpl customerService = new ICustomerServiceImpl();

    public static void main(String[] args) {
        CustomerDemo demo = new CustomerDemo();
        demo.runApp();
    }

    void runApp() {
        System.out.println("Register customer:");
        registerAndDisplay("Sushma", "Nayak");
        registerAndDisplay("Sushmitha", "Bhat");
        registerAndDisplay("Sushmi", "Pai");
        registerAndDisplay("Nidhi", "N");

        System.out.println("---------------------------------------------------" );

        System.out.println("Find by id:");
        findById(5);
        findById(2);
        findById(0);

        System.out.println("---------------------------------------------------");
        System.out.println("Customers by Id Ascending");
        findCustomersByFirstNameAscendingId("Sushmi");
        findCustomersByFirstNameAscendingId("su");

    }
    void registerAndDisplay(String firstName, String lastName){
        try {
         Customer customer = customerService.register(firstName, lastName);
            System.out.println(customer);
        }
        catch (InvalidInputException e){
            System.out.println(e.getMessage());
        }
    }

    void findCustomersByFirstNameAscendingId(String search){
        try {
            List<Customer> list = customerService.findCustomersByFirstNameAscendingId(search);
            customerService.display(list);

        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientTextException e) {
            System.out.println(e.getMessage());
        }
    }

    void findById(Integer id){
        try{
            Customer customer = customerService.findById(id);
            System.out.println(customer);
        } catch (CustomerNotFoundException | InvalidIdException e) {
            System.out.println(e.getMessage());
        }
    }
}
