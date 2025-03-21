package com.example.demo.Application.UseCasesImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.Application.Dtos.TransactionDto;
import com.example.demo.Application.UseCasesImpl.Factory.TransactionDtoFactory;
import com.example.demo.Application.UseCasesImpl.Factory.UsersFactory;
import com.example.demo.Core.Entities.Transactions.Transactions;
import com.example.demo.Core.Exeptions.UserServiceExepition;
import com.example.demo.Core.UseCases.TransactionRepositorysUseCase;
import com.example.demo.Core.UseCases.ValidationTransactionAndOtherMethodsUseCaseImpl;
import com.example.demo.Infra.JpaEntities.TrancsionEntities;
import com.example.demo.Infra.JpaEntities.UserEntities;

@ExtendWith(MockitoExtension.class)
public class CreateTransactionUseCaseImplTest {

    @Mock
    private ValidationTransactionAndOtherMethodsUseCaseImpl validationTransactionAndOtherMethodsUseCase;

    @Mock
    private TransactionRepositorysUseCase transactionSave;

    @InjectMocks
    private CreateTransactionUseCaseImpl createTransactionUseCaseImpl;

    private static final BigDecimal TRANSACTION_AMOUNT = new BigDecimal(10.00);
    private static final BigDecimal EXPECTED_SENDER = new BigDecimal(90.00);
    private static final BigDecimal EXPECTED_RECIVER = new BigDecimal(210.00);

    private UserEntities sender;
    private UserEntities reciver;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sender = UsersFactory.sender();
        reciver = UsersFactory.reciver();
        when(validationTransactionAndOtherMethodsUseCase.findByUserId(sender.getId())).thenReturn(sender);
        when(validationTransactionAndOtherMethodsUseCase.findByUserId(reciver.getId())).thenReturn(reciver);
    }

    @Test
    public void shouldReturnTransactionWhenAllConditionsAreValid() {
        TransactionDto transactionDto = TransactionDtoFactory.createTransactionDto(TRANSACTION_AMOUNT, sender.getId(), reciver.getId());

          TrancsionEntities transactions = createTransactionUseCaseImpl.createTransaction(transactionDto);
          assertNotNull(transactions);
          assertEquals(EXPECTED_SENDER, sender.getBalance());
          assertEquals(EXPECTED_RECIVER, reciver.getBalance());
          verify(validationTransactionAndOtherMethodsUseCase, Mockito.times(1)).findByUserId(sender.getId());
          verify(validationTransactionAndOtherMethodsUseCase, Mockito.times(1)).findByUserId(reciver.getId());
    }

    @Test
    public void shouldThrowExceptionWhenUserNotExist() {
      
        when(validationTransactionAndOtherMethodsUseCase.findByUserId(10L)).thenThrow(new UserServiceExepition("Esse id nao existe"));
        assertThrows(UserServiceExepition.class, () -> {
            validationTransactionAndOtherMethodsUseCase.findByUserId(10L);
        });
    }
}
