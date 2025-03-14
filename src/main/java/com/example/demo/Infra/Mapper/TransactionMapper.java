package com.example.demo.Infra.Mapper;

import com.example.demo.Application.Dtos.TransactionDto;
import com.example.demo.Core.Entities.Transactions.Transactions;
import com.example.demo.Infra.JpaEntities.TrancsionEntities;
import com.example.demo.Infra.JpaEntities.UserEntities;

public class TransactionMapper {

    // Mapeia de TrancsionEntities para Transactions
    public static Transactions toDomain(TrancsionEntities trancsionEntities) {
        if (trancsionEntities == null) {
            return null;
        }
        return new Transactions(
                trancsionEntities.getId(),
                trancsionEntities.getAmount(),
                trancsionEntities.getSender(),
                trancsionEntities.getReciver()
        );
    }
    
    public static TrancsionEntities toEntity(Transactions transactions) {
        if (transactions == null) {
            return null;
        }        
        TrancsionEntities trancsionEntities = new TrancsionEntities();
        trancsionEntities.setId(transactions.getId());
        trancsionEntities.setAmount(transactions.getAmount());
        trancsionEntities.setSender(transactions.getSender());
        trancsionEntities.setReciver(transactions.getReciver());
        trancsionEntities.setTimesTemp(transactions.getTimesTemp());
        return trancsionEntities;
    }
    public static Transactions toDomain(TransactionDto transactionDto, UserEntities sender, UserEntities reciver) {
        if (transactionDto == null || sender == null || reciver == null) {
            return null;
        }
        return new Transactions(
                null,  
                transactionDto.amount(),
                sender,
                reciver
        );
    }

    public static TrancsionEntities toEntity(TransactionDto transactionDto, UserEntities sender, UserEntities reciver) {
        if (transactionDto == null || sender == null || reciver == null) {
            return null;
        }

        TrancsionEntities trancsionEntities = new TrancsionEntities();
        trancsionEntities.setAmount(transactionDto.amount());
        trancsionEntities.setSender(sender);
        trancsionEntities.setReciver(reciver);
        trancsionEntities.setTimesTemp(null);  

        return trancsionEntities;
    }
}
