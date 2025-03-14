package com.example.demo.Infra.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Infra.JpaEntities.UserEntities;

public interface UserRepositorys extends JpaRepository<UserEntities, Long> {
    
}
