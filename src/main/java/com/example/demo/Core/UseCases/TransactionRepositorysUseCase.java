package com.example.demo.Core.UseCases;

import com.example.demo.Infra.JpaEntities.TrancsionEntities;

public interface TransactionRepositorysUseCase {
    public void save(TrancsionEntities transaction);
}
