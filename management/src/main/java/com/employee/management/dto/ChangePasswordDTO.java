package com.employee.management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChangePasswordDTO {

    @NotBlank(message = "New password is required")
    private String newPassword;

    @NotBlank(message = "Password confirmation is required")
    private String confirmNewPassword;
}