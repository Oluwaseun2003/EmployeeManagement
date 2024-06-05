package com.employee.management.enums;


import lombok.Getter;

@Getter
public enum Role {
    USER("USER"),
    ADMIN("ADMIN"),
    SUPERSTAFF("SUPERSTAFF")

    ;

    final String roleName;

    Role(String roleName){
        this.roleName = roleName;
    }
}
