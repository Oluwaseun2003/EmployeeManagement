package com.employee.management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ForgotPasswordDTO {

    @NotBlank(message = "email cannot be blank")
    private String email;

}
