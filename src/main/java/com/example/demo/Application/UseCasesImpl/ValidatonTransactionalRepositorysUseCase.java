package com.example.demo.Application.UseCasesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Core.Entities.Users;
import com.example.demo.Core.Exeptions.UserServiceExepition;
import com.example.demo.Core.UseCases.ValidationUserRepositoryUseCase;
import com.example.demo.Infra.Persistence.UserRepositorys;

@Component
public class ValidatonTransactionalRepositorysUseCase implements ValidationUserRepositoryUseCase{

    @Autowired
    private UserRepositorys userRepositorys;

    @Override
    public Users findById(Long id) {
       return userRepositorys.findById(id).orElseThrow(() -> {
           throw new UserServiceExepition("Id nao encontrado");
       });
    }
    
    @Override
    public void save(Users user) {
        userRepositorys.save(user);
    }
    
}
