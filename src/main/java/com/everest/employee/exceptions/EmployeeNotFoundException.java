package com.everest.employee.exceptions;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException() {
        super("No Employees found");
    }
}
