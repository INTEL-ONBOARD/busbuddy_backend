package com.userservice.controller;

import com.userservice.model.ApiResponse;
import com.userservice.model.User;
import com.userservice.model.UserCredentialsDTO;
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
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        try {
            User updatedUser = userService.updateUser(id, userDTO);
            ApiResponse response = new ApiResponse("User updated successfully", true, updatedUser);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("User update failed: " + e.getMessage(), false, null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            ApiResponse response = new ApiResponse("User deleted successfully", true, null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("User deletion failed: " + e.getMessage(), false, null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/check")
    public ResponseEntity<ApiResponse> checkUserCredentials(@RequestBody UserCredentialsDTO credentialsDTO) {
        try {
            // Use the service method to check if email and password are correct
            User user = userService.findByEmailAndCheckPassword(credentialsDTO.getEmail(), credentialsDTO.getPassword());

            if (user != null) {
                ApiResponse response = new ApiResponse("User exists", true, user);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                ApiResponse response = new ApiResponse("Invalid email or password", false, null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("Error: " + e.getMessage(), false, null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
