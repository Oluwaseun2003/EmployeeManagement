package com.employee.management.dto.employee;


import lombok.Data;

@Data
public class UpdateEmployeeRequest {
    private String phoneNumber;
    private String lastName;
    private String firstName;
    private String bio;
}
