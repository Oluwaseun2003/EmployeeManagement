package com.employee.management.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse<T> {

    private String responseCode;
    private String responseMessage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public ApiResponse(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }
}
