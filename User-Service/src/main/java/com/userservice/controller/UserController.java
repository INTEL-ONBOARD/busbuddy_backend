package com.userservice.controller;

import com.userservice.model.ApiResponse;
import com.userservice.model.User;
import com.userservice.model.UserDTO;

import com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createUser(@RequestBody UserDTO userDTO) {
        try {
            User createdUser = userService.createUser(userDTO);
            ApiResponse response = new ApiResponse("User created successfully", true, createdUser);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("User creation failed: " + e.getMessage(), false, null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long id) {
        try {
            User getuser = userService.getUserById(id);;
            ApiResponse response = new ApiResponse("User data read successfully", true, getuser);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("User read failed: " + e.getMessage(), false, null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
