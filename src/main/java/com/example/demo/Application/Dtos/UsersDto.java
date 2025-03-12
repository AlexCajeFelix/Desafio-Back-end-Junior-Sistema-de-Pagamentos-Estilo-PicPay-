package com.example.demo.Application.Dtos;

import java.math.BigDecimal;

import com.example.demo.Application.Enum.UserType;

public record UsersDto(String name, String email, String document, String password, BigDecimal balance, UserType type) {
    
}
