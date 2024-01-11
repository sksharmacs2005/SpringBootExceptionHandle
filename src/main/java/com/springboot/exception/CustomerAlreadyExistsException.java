package com.springboot.exception;


public class CustomerAlreadyExistsException extends RuntimeException {
    private String message;
    public CustomerAlreadyExistsException() {
    }
    public CustomerAlreadyExistsException(String msg) {
        super(msg);
       }
    public CustomerAlreadyExistsException(String message, Throwable throwable) {
        super(message, throwable);
    }

}