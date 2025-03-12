package com.example.demo.Infra.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Core.Entities.Transactions.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {
    
}
