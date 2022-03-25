package com.example.demo.exception;

public class ParametersInvalidException extends RuntimeException {
    public ParametersInvalidException(String message) {
        super(message);
    }
}
