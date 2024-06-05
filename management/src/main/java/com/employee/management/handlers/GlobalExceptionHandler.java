package com.employee.management.handlers;


import com.employee.management.dto.ApiResponse;
import com.employee.management.exceptions.EmployeeException;
import com.employee.management.exceptions.InvalidOtpException;
import com.employee.management.exceptions.PasswordException;
import com.employee.management.exceptions.RecordNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Order(1)
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ApiResponse<String> resourcesNotFoundException(HttpMessageNotReadableException ex) {
        return new ApiResponse<>("XX", "Provide a request body or param");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ApiResponse<String> wrongHttpMethod(HttpRequestMethodNotSupportedException ex) {
        return new ApiResponse<>("XX", ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RecordNotFoundException.class)
    public ApiResponse<String> recordNotFound(RecordNotFoundException ex) {
        return new ApiResponse<>("XX", ex.getMessage());
    }

    @ExceptionHandler(InvalidOtpException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<String> invalidOTP(InvalidOtpException ex) {
        return new ApiResponse<>("XX", ex.getMessage());
    }


    @ExceptionHandler(EmployeeException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiResponse<String> userAlreadyExists(EmployeeException ex) {
        return new ApiResponse<>("XX", ex.getMessage());
    }

    @ExceptionHandler(PasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<String> passwordExceptions(PasswordException ex) {
        return new ApiResponse<>("XX", ex.getMessage());
    }
}
