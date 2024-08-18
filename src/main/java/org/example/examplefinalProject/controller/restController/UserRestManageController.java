package org.example.examplefinalProject.controller.restController;

import lombok.RequiredArgsConstructor;
import org.example.examplefinalProject.entity.User;
import org.example.examplefinalProject.entity.dto.UserDto;
import org.example.examplefinalProject.mapper.UserMapper;
import org.example.examplefinalProject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserRestManageController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteUserAsAdmin")
    public ResponseEntity<String> deleteUserAsAdmin(Long userId) {
        try {
            userService.deleteUserAsAdmin(userId);
            return new ResponseEntity<>("user deleted", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
/*    @PreAuthorize("hasRole('USER')")
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteOwnAccount() {
        Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        userService.deleteUserAsTheUser();
        return ResponseEntity.ok("Account deleted successfully");
    }*/

    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllUsersAsAdmin")
    public ResponseEntity<List<UserDto>> getUserDto() {
        List<UserDto> userDtoList = new ArrayList<>();
        List<User> userList = userService.getUsers();
        for (User user:userList) {
            userDtoList.add(userMapper.userEntityToDto(user));
        }
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }
}

