package com.employee.management.exceptions;

public class InvalidOtpException extends RuntimeException{
    public InvalidOtpException(String message) {
        super(message);
    }
}
