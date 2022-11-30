package com.example.order.exceptions;

public class ItemDoesNotExistsException extends RuntimeException{
    public ItemDoesNotExistsException(String message) {
        super(message);
    }
}
