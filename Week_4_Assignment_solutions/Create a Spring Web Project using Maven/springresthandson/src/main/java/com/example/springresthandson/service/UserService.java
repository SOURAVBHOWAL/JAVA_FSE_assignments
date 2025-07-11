package com.example.springresthandson.service;

import com.example.springresthandson.entity.User;
import com.example.springresthandson.exception.ResourceNotFoundException;
import com.example.springresthandson.exception.DuplicateResourceException;
import com.example.springresthandson.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    // Get user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }
    
    // Create new user
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateResourceException("User with email " + user.getEmail() + " already exists");
        }
        return userRepository.save(user);
    }
    
    // Update user
    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        
        // Check if email is being changed and if the new email already exists
        if (!user.getEmail().equals(userDetails.getEmail()) && 
            userRepository.existsByEmail(userDetails.getEmail())) {
            throw new DuplicateResourceException("User with email " + userDetails.getEmail() + " already exists");
        }
        
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setAddress(userDetails.getAddress());
        user.setPhone(userDetails.getPhone());
        
        return userRepository.save(user);
    }
    
    // Delete user
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
    
    // Get user by email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // Search users by name
    public List<User> searchUsersByName(String name) {
        return userRepository.findByNameContainingIgnoreCase(name);
    }
    
    // Search users by name or email
    public List<User> searchUsers(String searchTerm) {
        return userRepository.findByNameOrEmailContaining(searchTerm);
    }
}
