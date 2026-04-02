package com.example.demo.Dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponseDTO {

    private String message;
    private String errorCode;
    private LocalDateTime timestamp;
    private String methodName;
    private String serviceName;
}