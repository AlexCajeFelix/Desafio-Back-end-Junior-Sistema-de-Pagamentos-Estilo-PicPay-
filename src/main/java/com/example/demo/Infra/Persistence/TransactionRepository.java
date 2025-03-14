package com.example.demo.Infra.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.Infra.JpaEntities.TrancsionEntities;

public interface TransactionRepository extends JpaRepository<TrancsionEntities, Long> {
    
}
