package com.example.demo.Core.UseCases;

import com.example.demo.Infra.JpaEntities.UserEntities;

public interface ValidationUserRepositoryUseCase {
        public UserEntities findById(Long id);
        public void save(UserEntities  user);
}
