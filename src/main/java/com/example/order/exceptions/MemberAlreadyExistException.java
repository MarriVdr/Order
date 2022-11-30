package com.example.order.exceptions;

public class MemberAlreadyExistException extends RuntimeException{
    public MemberAlreadyExistException(String message) {
        super(message);
    }
}
