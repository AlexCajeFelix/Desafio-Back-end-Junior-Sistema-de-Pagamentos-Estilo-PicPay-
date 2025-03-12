package com.example.demo.Core.UseCases;

import com.example.demo.Core.Entities.Users;

public interface ValidationUserRepositoryUseCase {
        public Users findById(Long id);
        public void save(Users user);
}
