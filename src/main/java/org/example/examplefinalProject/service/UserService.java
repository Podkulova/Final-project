package org.example.examplefinalProject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.example.examplefinalProject.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j

public class UserService {
    private final UserRepository userRepository;
    private final UserDetailsService CustomUserDetailsService;
    private final TeacherService teacherService;

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUserAsAdmin(Long userId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new RuntimeException("Authentication object is null");
        }

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        org.example.examplefinalProject.entity.User currentUser = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Authenticated user not found"));

        if (currentUser.getUserId().equals(userId)) {
            throw new RuntimeException("Admin cannot delete themselves");
        }

        org.example.examplefinalProject.entity.User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user); // Přidání této řádky pro skutečné smazání uživatele
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<org.example.examplefinalProject.entity.User> getUsers() {
        return userRepository.findAll();
    }

    public org.example.examplefinalProject.entity.User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !(authentication.getPrincipal() instanceof UserDetails)) {
            throw new RuntimeException("No authentication or principal found");
        }

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Authenticated user not found"));
    }

    // Optional: method to update user details
    @PreAuthorize("hasRole('USER')")
    public org.example.examplefinalProject.entity.User updateUserDetails(User updatedUser) {
        org.example.examplefinalProject.entity.User currentUser = getAuthenticatedUser();

        currentUser.setFirstName(updatedUser.getUsername());
/*        currentUser.setLastName(updatedUser.getLastName());
        currentUser.setEmail(updatedUser.getEmail());*/

        // Only update password if it's not empty
        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            currentUser.setPassword(updatedUser.getPassword());
        }

        return userRepository.save(currentUser);
    }
}


