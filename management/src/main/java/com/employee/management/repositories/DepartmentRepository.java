package com.employee.management.repositories;

import com.employee.management.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {

    boolean existsBySlug(String slug);

    Optional<Department> findBySlug(String slug);

    @Query("Select d From Department d where d.slug is null ")
    List<Department> getDepartmentWithoutSlug();

    @Query("SELECT COUNT(c) FROM Department d")
    long countDepartments();

    @Query("SELECT COUNT(d) FROM Department d WHERE d.createdAt >= :startDate")
    long countNewDepartments(@Param("startDate") LocalDateTime startDate);

}
