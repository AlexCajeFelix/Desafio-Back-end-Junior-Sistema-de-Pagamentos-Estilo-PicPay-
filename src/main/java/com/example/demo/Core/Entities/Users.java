package com.example.demo.Core.Entities;

import java.math.BigDecimal;

import com.example.demo.Application.Dtos.UsersDto;
import com.example.demo.Application.Enum.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "users")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String document;

    private String password;

    private BigDecimal balance;

    @Enumerated(jakarta.persistence.EnumType.STRING)
    private UserType type;

    public Users(UsersDto user) {
        this.name = user.name();
        this.email = user.email();
        this.document = user.document();
        this.password = user.password();
        this.balance = user.balance();
        this.type = user.type();
    }

    public Users orElseThrow(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orElseThrow'");
    }


    
}
