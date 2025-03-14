package com.example.demo.Core.Entities.Transactions;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.demo.Infra.JpaEntities.UserEntities;

public class Transactions {
 
    private Long id;
    private BigDecimal amount;
    private UserEntities sender;
    private UserEntities reciver;
    private LocalDate timesTemp;


    public Transactions(Long id, BigDecimal amount, UserEntities sender, UserEntities reciver) {
        this.id = id;
        this.amount = amount;
        this.sender = sender;
        this.reciver = reciver;
        this.timesTemp = LocalDate.now();
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public BigDecimal getAmount() {
        return amount;
    }


    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public UserEntities getSender() {
        return sender;
    }


    public void setSender(UserEntities sender) {
        this.sender = sender;
    }


    public UserEntities getReciver() {
        return reciver;
    }


    public void setReciver(UserEntities reciver) {
        this.reciver = reciver;
    }


    public LocalDate getTimesTemp() {
        return timesTemp;
    }


    public void setTimesTemp(LocalDate timesTemp) {
        this.timesTemp = timesTemp;
    }

    

}
