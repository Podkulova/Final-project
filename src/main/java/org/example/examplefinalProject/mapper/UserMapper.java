package org.example.examplefinalProject.mapper;

import org.example.examplefinalProject.entity.User;
import org.example.examplefinalProject.entity.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto userEntityToDto(User user) {
        UserDto userGetUserDto = UserDto.builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
        return userGetUserDto;
    }
}
