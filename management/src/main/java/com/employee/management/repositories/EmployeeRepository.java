package com.employee.management.repositories;

import com.employee.management.entities.Employee;
import com.employee.management.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository <Employee, Integer>, JpaSpecificationExecutor<Employee> {
    Optional<Employee> findByOtp(@Param("otp") String otp, @Param("email") String email);

    boolean existByEmail(String email);

    Optional<Employee> findByMagicCode(String phoneNumber);

    boolean existsByPhoneNumber(String phoneNumber);

    List<Employee> findAllByRole(Role role);

    @Query("SELECT COUNT(e) FROM Employee e WHERE e.role = 'Employee'")
    long countEmployee();

    @Query("SELECT COUNT(e) FROM Employee c WHERE c.createdAt >= :startDate")
    long countNewEmployee(@Param("startDate") LocalDateTime startDate);


}
