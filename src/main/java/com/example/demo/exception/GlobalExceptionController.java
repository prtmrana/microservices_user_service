package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.Dto.ErrorResponseDTO;
import com.example.demo.customExceptions.UserAlreadyPresentException;
import com.example.demo.customExceptions.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> userNotFound(UserNotFoundException ex) {
		 ErrorResponseDTO error = ErrorResponseDTO.builder()
		            .message(ex.getMessage())
		            .errorCode("USER_NOT_FOUND")
		            .timestamp(LocalDateTime.now())
		            .serviceName("UserService")
		            .build();
		 
		 return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserAlreadyPresentException.class)
	public ResponseEntity<ErrorResponseDTO> userAlreadyPresent(UserAlreadyPresentException ex) {
		 ErrorResponseDTO error = ErrorResponseDTO.builder()
		            .message(ex.getMessage())
		            .errorCode("USER_ALREADY_PRESENT")
		            .timestamp(LocalDateTime.now())
		            .serviceName("UserService")
		            .build();
		 
		 return new ResponseEntity<>(error, HttpStatus.ALREADY_REPORTED);
	}
}
