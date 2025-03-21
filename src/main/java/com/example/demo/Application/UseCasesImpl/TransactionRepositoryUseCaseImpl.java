package com.example.demo.Application.UseCasesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.example.demo.Core.UseCases.TransactionRepositorysUseCase;
import com.example.demo.Infra.JpaEntities.TrancsionEntities;
import com.example.demo.Infra.Persistence.TransactionRepository;

@Component
public class TransactionRepositoryUseCaseImpl implements TransactionRepositorysUseCase{


    @Autowired
    private TransactionRepository transactionSave;
    @Override
    public void save(TrancsionEntities transaction) {
        transactionSave.save(transaction);
    }

  
    
}
