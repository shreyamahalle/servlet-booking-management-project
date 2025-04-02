package com.shreya.servlet.exception;


public class CustomerException extends RuntimeException{
    public CustomerException(String NotAvailable){

        super(NotAvailable);
    }
}
