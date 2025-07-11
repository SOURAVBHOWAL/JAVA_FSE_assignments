package com.example.springresthandson.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springresthandson.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Find user by email
    Optional<User> findByEmail(String email);
    
    // Find users by name containing (case-insensitive)
    List<User> findByNameContainingIgnoreCase(String name);
    
    // Custom query to find users by name or email
    @Query("SELECT u FROM User u WHERE u.name LIKE %:searchTerm% OR u.email LIKE %:searchTerm%")
    List<User> findByNameOrEmailContaining(@Param("searchTerm") String searchTerm);
    
    // Check if email exists
    boolean existsByEmail(String email);
}