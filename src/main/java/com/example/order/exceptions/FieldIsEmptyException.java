package com.example.order.exceptions;

public class FieldIsEmptyException extends RuntimeException{
    public FieldIsEmptyException(String message) {
        super(message);
    }
}
