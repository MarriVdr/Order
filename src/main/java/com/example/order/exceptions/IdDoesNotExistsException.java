package com.example.order.exceptions;

public class IdDoesNotExistsException extends RuntimeException{
    public IdDoesNotExistsException(String message) {
        super(message);
    }
}
