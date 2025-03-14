package com.example.demo.Application.UseCasesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.Core.UseCases.ValidationUserRepositoryUseCase;
import com.example.demo.Infra.JpaEntities.UserEntities;
import com.example.demo.Infra.Persistence.UserRepositorys;

@Component
public class ValidatonTransactionalRepositorysUseCase implements ValidationUserRepositoryUseCase{

    @Autowired
    private UserRepositorys userRepositorys;

   
    @Override
    public void save(UserEntities user) {
        userRepositorys.save(user);
    }

    @Override
    public UserEntities findById(Long id) {
        return userRepositorys.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    
    
}
