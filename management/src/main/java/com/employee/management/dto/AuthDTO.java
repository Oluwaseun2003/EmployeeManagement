package com.employee.management.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthDTO {

    private String email;
    private String password;

}
