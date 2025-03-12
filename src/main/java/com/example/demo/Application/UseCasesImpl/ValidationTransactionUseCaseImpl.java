package com.example.demo.Application.UseCasesImpl;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Application.Enum.UserType;
import com.example.demo.Core.Entities.Users;
import com.example.demo.Core.Exeptions.UserServiceExepition;
import com.example.demo.Core.UseCases.ValidationUserRepositoryUseCase;
import com.example.demo.Core.UseCases.ValidationTransactionAndOtherMethodsUseCaseImpl;


@Service
public class ValidationTransactionUseCaseImpl implements ValidationTransactionAndOtherMethodsUseCaseImpl{

    @Autowired
    private ValidationUserRepositoryUseCase UserRepositorys;

    @Override
    public void validationTransaction(Users sender, BigDecimal amount, Users reciver) {
       if(sender.getType() != UserType.USUARIO) {
            throw new UserServiceExepition("Só os usuarios podem fazer transações");
        }
        if(amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new UserServiceExepition("O valor nao pode ser negativo");
        }
        if(sender.getBalance().compareTo(amount)  <= 0) {
            throw new UserServiceExepition("Insuficiente o saldo");
        } 
        if(sender.equals(reciver)) {
            throw new UserServiceExepition("Nao pode transferir para si mesmo");
        }
}   
 
    @Override
    public Users findByUserId(Long id) {
        return UserRepositorys.findById(id).orElseThrow(new UserServiceExepition("Esse id nao existe"));
            
    }
    
    @Override
    public void saveUser(Users user) {
        if(user != null) {
            UserRepositorys.save(user);
        }else{
            throw new UserServiceExepition("User nao pode ser nulo");
        }
    }

    
}
    
