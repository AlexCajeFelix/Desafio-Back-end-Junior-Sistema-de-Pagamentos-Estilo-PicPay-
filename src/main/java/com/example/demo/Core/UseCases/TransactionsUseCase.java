package com.example.demo.Core.UseCases;

import com.example.demo.Application.Dtos.TransactionDto;
import com.example.demo.Core.Entities.Transactions.Transactions;

public interface TransactionsUseCase {
        public Transactions createTransaction(TransactionDto transactionDto);
}
