package com.example.demo.Application.UseCasesImpl.Factory;

import java.math.BigDecimal;

import com.example.demo.Application.Enum.UserType;
import com.example.demo.Core.Entities.Users;
import com.example.demo.Infra.JpaEntities.UserEntities;


public class UsersFactory {

    private static  BigDecimal BALANCE_SENDER = new BigDecimal(100.00);
    private static  BigDecimal BALANCE_RECIVER = new BigDecimal(200.00);
    private static  BigDecimal TRANSACTION_AMOUNT = new BigDecimal(10.00);
    private static  Long SENDER_ID = 1L;
    private static  Long RECEIVER_ID = 2L;

    // Métodos de fábrica
    public static UserEntities sender() {
        return new UserEntities(
                SENDER_ID,                  
                "Alex",                     
                "alex@gmail.com",        
                "123456789",                   
                "password123",                 
                BALANCE_SENDER,               
                UserType.USUARIO               
        );
    }

    public static UserEntities reciver() {
        return new UserEntities(
                RECEIVER_ID,                  
                "Maria",                       
                "maria@lojista.com",           
                "987654321",                   
                "lojista123",                  
                BALANCE_RECIVER,              
                UserType.USUARIO              
        );
    }

   
    public static BigDecimal getTransactionAmount() {
        return TRANSACTION_AMOUNT;
    }

    public static BigDecimal getExpectedSenderBalance() {
        return BALANCE_SENDER.subtract(TRANSACTION_AMOUNT); 
    }

    public static BigDecimal getExpectedReceiverBalance() {
        return BALANCE_RECIVER.add(TRANSACTION_AMOUNT);  
    }
}

