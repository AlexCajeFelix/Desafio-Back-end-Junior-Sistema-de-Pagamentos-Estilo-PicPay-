package com.example.demo.Application.UseCasesImpl.Factory;

import java.math.BigDecimal;

import com.example.demo.Application.Dtos.TransactionDto;

public class TransactionDtoFactory {

  
    private static  BigDecimal DEFAULT_AMOUNT = new BigDecimal("10.00");
    private static  Long DEFAULT_SENDER_ID = 1L;
    private static  Long DEFAULT_RECIVER_ID = 2L;

  
    public static TransactionDto createTransactionDto() {
        return new TransactionDto(DEFAULT_AMOUNT, DEFAULT_SENDER_ID, DEFAULT_RECIVER_ID);
    }

    public static TransactionDto createTransactionDto(BigDecimal amount, Long senderId, Long reciverId) {
        return new TransactionDto(amount, senderId, reciverId);
    }
}
