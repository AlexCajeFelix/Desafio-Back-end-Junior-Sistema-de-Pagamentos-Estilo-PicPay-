package com.example.demo.Application.Dtos;

import java.math.BigDecimal;

public record TransactionDto(
    
    BigDecimal amount,
    Long senderId,
    Long reciverId

) {

}
