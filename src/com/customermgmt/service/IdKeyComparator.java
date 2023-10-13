package com.customermgmt.service;

import com.customermgmt.domain.Customer;

import java.util.Comparator;

public class IdKeyComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer customer1, Customer customer2) {
        return customer1.getId()-customer2.getId();
    }
}

