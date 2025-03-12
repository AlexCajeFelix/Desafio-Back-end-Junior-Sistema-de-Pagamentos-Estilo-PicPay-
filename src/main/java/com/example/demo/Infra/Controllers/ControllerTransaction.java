package com.example.demo.Infra.Controllers;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Application.Dtos.TransactionDto;
import com.example.demo.Application.UseCasesImpl.CreateTransactionUseCaseImpl;
import com.example.demo.Core.Entities.Transactions.Transactions;


@RestController
@RequestMapping("/transaction")
public class ControllerTransaction {

    @Autowired
    private CreateTransactionUseCaseImpl transactionsService;

    @PostMapping
    public ResponseEntity<Transactions> createTransacvtion(@RequestBody TransactionDto transactionDto) {
        var transaction = transactionsService.createTransaction(transactionDto);
        return ResponseEntity.ok(transaction);
        
    }

    
}
