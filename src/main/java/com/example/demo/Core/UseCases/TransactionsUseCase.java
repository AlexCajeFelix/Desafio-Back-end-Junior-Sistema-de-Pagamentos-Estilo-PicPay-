package com.example.demo.Core.UseCases;

import com.example.demo.Application.Dtos.TransactionDto;
import com.example.demo.Infra.JpaEntities.TrancsionEntities;

public interface TransactionsUseCase {
        public TrancsionEntities createTransaction(TransactionDto transactionDto);
}
