package com.userservice.service;

import com.userservice.model.UserDTO;
import com.userservice.model.User;
import com.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User createUser(UserDTO userDTO) {
        User user = new User();

        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhone(userDTO.getPhone());
        user.setBio(userDTO.getBio());


        userRepository.save(user);

        return user;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public User updateUser(Long id, UserDTO userDTO) throws Exception {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Update user fields
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setPhone(userDTO.getPhone());
            user.setBio(userDTO.getBio());

            return userRepository.save(user); // Save updated user
        } else {
            throw new Exception("User not found");
        }
    }

    public void deleteUser(Long id) throws Exception {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new Exception("User not found");
        }
    }

    public User findByEmailAndCheckPassword(String email, String password) {
        // Find the user by email
        User user = userRepository.findByEmail(email);

        // Check if user exists and the password matches
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        // Return null if user not found or password does not match
        return null;
    }

}
