package com.vrs.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private T data;
//
//    public ApiResponse(int status, String message, T data) {
//        this.timestamp = LocalDateTime.now();
//        this.status = status;
//        this.message = message;
//        this.data = data;
//    }

    // Getters & setters
}
