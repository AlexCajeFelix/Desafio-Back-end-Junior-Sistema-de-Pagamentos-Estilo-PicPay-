package com.example.demo.Application.UseCasesImpl;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Application.Enum.UserType;
import com.example.demo.Core.Exeptions.UserServiceExepition;
import com.example.demo.Core.UseCases.ValidationUserRepositoryUseCase;
import com.example.demo.Infra.JpaEntities.UserEntities;
import com.example.demo.Core.UseCases.ValidationTransactionAndOtherMethodsUseCaseImpl;
@Service
public class ValidationTransactionUseCaseImpl implements ValidationTransactionAndOtherMethodsUseCaseImpl{

    @Autowired
    private ValidationUserRepositoryUseCase UserRepositorys;

    @Override
    public void validationTransaction(UserEntities sender, BigDecimal amount, UserEntities reciver) {
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
    public UserEntities findByUserId(Long id) {
        return UserRepositorys.findById(id);
            
    }
    
    @Override
    public void saveUser(UserEntities  user) {
        if(user != null) {
            UserRepositorys.save(user);
        }else{
            throw new UserServiceExepition("User nao pode ser nulo");
        }
    }

   

    
}
    
