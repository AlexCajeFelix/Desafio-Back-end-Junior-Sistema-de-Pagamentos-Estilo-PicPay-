package com.example.demo.Core.Entities;

import java.math.BigDecimal;
import com.example.demo.Application.Dtos.UsersDto;
import com.example.demo.Application.Enum.UserType;


public class Users {

   
    private Long id;

    private String name;

  
    private String email;

   
    private String document;

    private String password;

    private BigDecimal balance;

 
    private UserType type;

    public Users(UsersDto user) {
        this.name = user.name();
        this.email = user.email();
        this.document = user.document();
        this.password = user.password();
        this.balance = user.balance();
        this.type = user.type();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    
    


    
}
