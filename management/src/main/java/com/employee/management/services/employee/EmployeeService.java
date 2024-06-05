package com.employee.management.services.employee;

import com.employee.management.dto.AuthDTO;
import com.employee.management.dto.ChangePasswordDTO;
import com.employee.management.dto.ForgotPasswordDTO;
import com.employee.management.dto.VerifyDTO;
import com.employee.management.dto.department.EmployeeWithDept;
import com.employee.management.dto.employee.EmployeeDto;
import com.employee.management.dto.employee.MagicLinkDto;
import com.employee.management.dto.employee.UpdateEmployeeRequest;
import com.employee.management.entities.Employee;
import org.springframework.data.domain.Page;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface EmployeeService {
    Map<String, Object> login(AuthDTO authDTO);

    Employee createEmployee(EmployeeDto employeeDto);

    Employee updateEmployee(UpdateEmployeeRequest updateEmployeeRequest, Principal principal);

    List<Employee> getAllEmployee();

    Employee getEmployee(int id);

    Employee deleteEmployee(int id);

    Map<String, Object> verifyOTP(VerifyDTO verifyDTO);

    String forgotPassword(ForgotPasswordDTO forgotPasswordDTO);
    Map<String, Object> verifyMagicLink(MagicLinkDto magicLinkDto);

    String changePassword(ChangePasswordDTO changePasswordDTO, Principal principal);

    Page<EmployeeWithDept> getEmployee(Integer page, Integer size, String search, Boolean isVerified);


}
