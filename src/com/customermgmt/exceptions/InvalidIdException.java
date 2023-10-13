package com.customermgmt.exceptions;

public class InvalidIdException extends Exception{
    public InvalidIdException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return "Invalid ID";
    }
}
