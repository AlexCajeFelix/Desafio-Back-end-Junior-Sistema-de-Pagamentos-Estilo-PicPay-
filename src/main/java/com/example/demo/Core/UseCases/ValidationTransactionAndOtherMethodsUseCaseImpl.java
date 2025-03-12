package com.example.demo.Core.UseCases;

import java.math.BigDecimal;
import com.example.demo.Core.Entities.Users;

public interface  ValidationTransactionAndOtherMethodsUseCaseImpl {
            public void validationTransaction(Users sender, BigDecimal amount, Users reciver);
            public Users findByUserId(Long id);
            public void saveUser(Users user);
}
