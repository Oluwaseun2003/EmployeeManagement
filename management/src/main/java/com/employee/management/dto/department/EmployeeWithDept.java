package com.employee.management.dto.department;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWithDept {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private boolean verified;
    private String bio;
    private String image;
    private String fullName;
    private String email;
    private List<DeptInfo> courses;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeptInfo {
        private int deptId;
        private String deptName;
    }
}
