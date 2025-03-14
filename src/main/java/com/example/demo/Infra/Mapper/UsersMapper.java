package com.example.demo.Infra.Mapper;

import com.example.demo.Application.Dtos.UsersDto;
import com.example.demo.Core.Entities.Users;
import com.example.demo.Infra.JpaEntities.UserEntities;

public class UsersMapper {

    public static Users toDomain(UsersDto dto) {
        return new Users(dto);
    }
    public static UsersDto toDto(Users user) {
        return new UsersDto(
            user.getName(),
            user.getEmail(),
            user.getDocument(),
            user.getPassword(),
            user.getBalance(),
            user.getType()
        );
    }
    public static Users toDomain(UserEntities entity) {
        return new Users(
            new UsersDto(
                entity.getName(),
                entity.getEmail(),
                entity.getDocument(),
                entity.getPassword(),
                entity.getBalance(),
                entity.getType()
            )
        );
    }
    public static UserEntities toEntity(Users user) {
        return new UserEntities(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getDocument(),
            user.getPassword(),
            user.getBalance(),
            user.getType()
        );
    }
}
