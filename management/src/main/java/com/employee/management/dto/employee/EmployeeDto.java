package com.employee.management.dto.employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class EmployeeDto {

    @NotBlank(message = "firstName cannot be blank")
    private String firstName;

    @NotBlank(message = "lastName cannot be blank")
    private String lastName;

    @Pattern(regexp = "[a-zA-Z0-9.+_-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
    @NotBlank(message = "email cannot be blank")
    private String email;

    private String password;
    private String role;

    @NotBlank(message = "phoneNumber cannot be blank")
    private String phoneNumber;
    private String userName;


}
