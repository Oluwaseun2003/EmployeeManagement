package com.employee.management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VerifyDTO {
    @NotBlank(message = "OTP is required")
    String otp;
    @NotBlank(message = "Email is required")
    String email;
}
