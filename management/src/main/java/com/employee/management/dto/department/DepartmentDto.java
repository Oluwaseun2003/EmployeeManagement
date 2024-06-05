package com.employee.management.dto.department;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    @NotBlank(message = "Department name cannot be blank")
    private String name;

    @NotBlank(message = "Department description cannot be blank")
    private String description;

    @NotBlank(message = "Department summary cannot be blank")
    private String summary;
}
