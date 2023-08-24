package com.nikkhat.UserService.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ApiResponse {

    private String message;

    private boolean success;

    private HttpStatus status;
}
