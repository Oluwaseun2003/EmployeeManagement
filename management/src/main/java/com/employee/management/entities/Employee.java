package com.employee.management.entities;


import com.employee.management.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Employee")
public class Employee implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @ManyToOne
    private Department department;

    @Enumerated(EnumType.STRING)
    @ManyToOne
    private Role role;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(unique = true)
    private String phoneNumber;
    private String userName;

    private String otp;

    private String bio;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private final List<Department> departments = new ArrayList<>();

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean verified;


    @Column(name = "reset_password_code")
    @JsonIgnore
    private String resetPasswordCode;

    @Column(name = "magic_code")
    @JsonIgnore
    private String magicCode;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  LocalDateTime updatedAt;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role.getRoleName()));
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return "email";
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return verified;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
