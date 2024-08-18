package org.example.examplefinalProject.entity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.examplefinalProject.entity.Role;

@Builder
@Getter
@Setter
public class UserDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;

}
