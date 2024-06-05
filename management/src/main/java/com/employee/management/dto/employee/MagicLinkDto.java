package com.employee.management.dto.employee;

import jakarta.validation.constraints.NotBlank;

public class MagicLinkDto {
    @NotBlank(message = "magic link code cannot be blank")
    private String magicCode;
}
