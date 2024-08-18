package org.example.examplefinalProject.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponseDto {
    private String jwtToken;

    public AuthenticationResponseDto(String jwtToken) {
        this.jwtToken = jwtToken;
    }

}
