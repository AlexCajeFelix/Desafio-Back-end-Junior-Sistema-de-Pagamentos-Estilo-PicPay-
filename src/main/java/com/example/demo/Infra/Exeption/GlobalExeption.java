package com.example.demo.Infra.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.Core.Exeptions.UserServiceExepition;

@RestControllerAdvice
public class GlobalExeption {
    @ExceptionHandler(UserServiceExepition.class)
    public ResponseEntity<String> handleUserServiceExepition(UserServiceExepition exepition) {
        return new ResponseEntity<String>(exepition.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception exception) {
        return new ResponseEntity<>("Erro inesperado: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
}
