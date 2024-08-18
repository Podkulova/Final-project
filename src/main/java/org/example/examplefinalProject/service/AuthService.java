package org.example.examplefinalProject.service;

import lombok.RequiredArgsConstructor;
import org.example.examplefinalProject.entity.Role;
import org.example.examplefinalProject.entity.User;
import org.example.examplefinalProject.entity.dto.AuthenticationRequestDto;
import org.example.examplefinalProject.entity.dto.AuthenticationResponseDto;
import org.example.examplefinalProject.entity.dto.UserRegisterDto;
import org.example.examplefinalProject.repository.UserRepository;
import org.example.examplefinalProject.util.JwtUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;


    public User register(UserRegisterDto registerRequest) {
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already taken"); // Or create a custom exception
        }
        User user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();

        return userRepository.save(user);
    }

    //backend feature only
    public User registerAsAdmin(UserRegisterDto registerRequest) {
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already taken"); // Or create a custom exception
        }
        User user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.ADMIN)
                .build();

        return userRepository.save(user);
    }

    public AuthenticationResponseDto login(AuthenticationRequestDto authenticationRequest) {
        User user = userRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword())) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail()); // Load UserDetails
            String jwtToken = jwtUtil.generateToken(userDetails, user.getUserId()); // Generate JWT token with userId
            return new AuthenticationResponseDto(jwtToken);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
