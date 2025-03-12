package com.example.demo.Infra.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Core.Entities.Users;

public interface UserRepositorys extends JpaRepository<Users, Long> {
    
}
