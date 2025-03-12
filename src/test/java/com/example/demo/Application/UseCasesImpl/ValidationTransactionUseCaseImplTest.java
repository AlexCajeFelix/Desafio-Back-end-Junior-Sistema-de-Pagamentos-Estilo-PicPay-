package com.example.demo.Application.UseCasesImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.example.demo.Application.Enum.UserType;
import com.example.demo.Application.UseCasesImpl.Factory.UsersFactory;
import com.example.demo.Core.Entities.Users;
import com.example.demo.Core.Exeptions.UserServiceExepition;
import com.example.demo.Core.UseCases.ValidationUserRepositoryUseCase;


public class ValidationTransactionUseCaseImplTest {
   

    @Mock
    private ValidationUserRepositoryUseCase UserRepositorys;

    @InjectMocks
    private ValidationTransactionUseCaseImpl validationTransactionUseCaseImpl;
    
    @BeforeEach
    public void setup() {
         MockitoAnnotations.openMocks(this);
         Users sender = UsersFactory.sender();
         Users reciver = UsersFactory.reciver();
         
    }

    @Test 
    public void shouldThrowExceptionWhenSenderIsLojista() {
        Users sender = UsersFactory.sender();
        sender.setType(UserType.LOJISTA);
        Users reciver = UsersFactory.reciver();

        UserServiceExepition exception = assertThrows(UserServiceExepition.class, () -> {
            validationTransactionUseCaseImpl.validationTransaction(sender, new BigDecimal(10.00), reciver);
        });
    }
        
    @Test 
    public void shouldThrowExceptionWhenAmountIsNegative() {
        Users sender = UsersFactory.sender();
        Users reciver = UsersFactory.reciver();
        UserServiceExepition exception = assertThrows(UserServiceExepition.class, () -> {
            validationTransactionUseCaseImpl.validationTransaction(sender, new BigDecimal(-10.00), reciver);
        });
    }
    
    @Test 
    public void shouldThrowExceptionWhenSenderBalanceIsLessThanAmount() {
        Users sender = UsersFactory.sender();
        Users reciver = UsersFactory.reciver();
        UserServiceExepition exception = assertThrows(UserServiceExepition.class, () -> {
            validationTransactionUseCaseImpl.validationTransaction(sender, new BigDecimal(200.00), reciver);
        });
    }

    @Test 
    public void shouldThrowExceptionWhenSenderAndReciverAreTheSame() {
        Users sender = UsersFactory.sender();
        Users reciver = UsersFactory.reciver();
        UserServiceExepition exception = assertThrows(UserServiceExepition.class, () -> {
            validationTransactionUseCaseImpl.validationTransaction(sender, new BigDecimal(10.00), sender);
        });
    }

 
    
  
}
