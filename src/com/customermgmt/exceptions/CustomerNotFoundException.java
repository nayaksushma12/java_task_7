package com.customermgmt.exceptions;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return "Customer not found";
    }
}
