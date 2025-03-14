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
import com.example.demo.Core.Exeptions.UserServiceExepition;
import com.example.demo.Core.UseCases.ValidationUserRepositoryUseCase;
import com.example.demo.Infra.JpaEntities.UserEntities;


public class ValidationTransactionUseCaseImplTest {
   

    @Mock
    private ValidationUserRepositoryUseCase UserRepositorys;

    @InjectMocks
    private ValidationTransactionUseCaseImpl validationTransactionUseCaseImpl;
    
    @BeforeEach
    public void setup() {
         MockitoAnnotations.openMocks(this);
         UserEntities sender = UsersFactory.sender();
         UserEntities reciver = UsersFactory.reciver();
         
    }

    @Test 
    public void shouldThrowExceptionWhenSenderIsLojista() {
        UserEntities sender = UsersFactory.sender();
        sender.setType(UserType.LOJISTA);
        UserEntities reciver = UsersFactory.reciver();

        UserServiceExepition exception = assertThrows(UserServiceExepition.class, () -> {
            validationTransactionUseCaseImpl.validationTransaction(sender, new BigDecimal(10.00), reciver);
        });
    }
        
    @Test 
    public void shouldThrowExceptionWhenAmountIsNegative() {
        UserEntities sender = UsersFactory.sender();
        UserEntities reciver = UsersFactory.reciver();
        UserServiceExepition exception = assertThrows(UserServiceExepition.class, () -> {
            validationTransactionUseCaseImpl.validationTransaction(sender, new BigDecimal(-10.00), reciver);
        });
    }
    
    @Test 
    public void shouldThrowExceptionWhenSenderBalanceIsLessThanAmount() {
        UserEntities sender = UsersFactory.sender();
        UserEntities reciver = UsersFactory.reciver();
        UserServiceExepition exception = assertThrows(UserServiceExepition.class, () -> {
            validationTransactionUseCaseImpl.validationTransaction(sender, new BigDecimal(200.00), reciver);
        });
    }

    @Test 
    public void shouldThrowExceptionWhenSenderAndReciverAreTheSame() {
        UserEntities sender = UsersFactory.sender();
        UserEntities reciver = UsersFactory.reciver();
        UserServiceExepition exception = assertThrows(UserServiceExepition.class, () -> {
            validationTransactionUseCaseImpl.validationTransaction(sender, new BigDecimal(10.00), sender);
        });
    }

 
    
  
}
