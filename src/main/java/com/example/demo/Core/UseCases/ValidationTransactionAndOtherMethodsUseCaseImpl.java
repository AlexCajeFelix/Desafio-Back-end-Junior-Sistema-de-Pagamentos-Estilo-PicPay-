package com.example.demo.Core.UseCases;

import java.math.BigDecimal;
import com.example.demo.Infra.JpaEntities.UserEntities;

public interface  ValidationTransactionAndOtherMethodsUseCaseImpl {
            public void validationTransaction(UserEntities sender, BigDecimal amount, UserEntities reciver);
            public UserEntities findByUserId(Long id);
            public void saveUser(UserEntities user);
}
