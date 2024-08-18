package org.example.examplefinalProject.controller.restController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.examplefinalProject.entity.dto.AuthenticationRequestDto;
import org.example.examplefinalProject.entity.dto.AuthenticationResponseDto;
import org.example.examplefinalProject.entity.dto.UserRegisterDto;
import org.example.examplefinalProject.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthRestController {

    private final AuthService authService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserRegisterDto registerRequest) {
        try {
            authService.register(registerRequest);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //backend feature only
    @PostMapping("/registerAsAdmin")
    public ResponseEntity<String> registerAsAdmin(@Valid @RequestBody UserRegisterDto registerRequest) {
        try {
            authService.registerAsAdmin(registerRequest);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDto authenticationRequest) {
        try {
            AuthenticationResponseDto response = authService.login(authenticationRequest);
            log.info("user logged in");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}