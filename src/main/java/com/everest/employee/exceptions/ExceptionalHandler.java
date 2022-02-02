package com.everest.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionalHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> errorMessage(EmployeeNotFoundException f)
    {
        return new ResponseEntity<>(f.getMessage(), HttpStatus.NOT_FOUND);
    }
}
