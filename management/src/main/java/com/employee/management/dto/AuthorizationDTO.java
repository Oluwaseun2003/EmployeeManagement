package com.employee.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationDTO {
    private int EmployeeId;
    private String EmployeeEmail;
    private String EmployeeCode;
    private String authorizationCode;
}
