package com.example.demo.Application.UseCasesImpl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Application.Dtos.TransactionDto;
import com.example.demo.Core.UseCases.TransactionRepositorysUseCase;
import com.example.demo.Core.UseCases.TransactionsUseCase;
import com.example.demo.Core.UseCases.ValidationTransactionAndOtherMethodsUseCaseImpl;
import com.example.demo.Infra.JpaEntities.UserEntities;
import com.example.demo.Infra.JpaEntities.TrancsionEntities;

import jakarta.transaction.Transactional;

@Service
public class CreateTransactionUseCaseImpl implements TransactionsUseCase {

    @Autowired
    private TransactionRepositorysUseCase transactionSave;

    @Autowired
    private ValidationTransactionAndOtherMethodsUseCaseImpl ValidationTransactionAndOtherMethodsUseCaseImpl;

    @Transactional
    @Override
    public TrancsionEntities createTransaction(TransactionDto transactionDto) {
       
            UserEntities sender = ValidationTransactionAndOtherMethodsUseCaseImpl.findByUserId(transactionDto.senderId());
            UserEntities reciver = ValidationTransactionAndOtherMethodsUseCaseImpl.findByUserId(transactionDto.reciverId());
            
            ValidationTransactionAndOtherMethodsUseCaseImpl.validationTransaction(sender, transactionDto.amount(), reciver);
            
                sender.setBalance(sender.getBalance().subtract(transactionDto.amount()));
                ValidationTransactionAndOtherMethodsUseCaseImpl.saveUser(sender);
       
                reciver.setBalance(reciver.getBalance().add(transactionDto.amount()));
                ValidationTransactionAndOtherMethodsUseCaseImpl.saveUser(reciver);

            
                

                TrancsionEntities transaction = new TrancsionEntities(null, transactionDto.amount(), sender, reciver, LocalDate.now());
            transactionSave.save(transaction);

            return transaction;

        }   
    }

