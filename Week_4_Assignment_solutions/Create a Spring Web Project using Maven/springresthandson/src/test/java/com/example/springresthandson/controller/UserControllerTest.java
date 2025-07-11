package com.example.springresthandson.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.springresthandson.entity.User;
import com.example.springresthandson.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private UserService userService;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    public void testGetAllUsers() throws Exception {
        // Given
        User user1 = new User("John Doe", "john@example.com", "123 Main St", "555-0123");
        user1.setId(1L);
        User user2 = new User("Jane Smith", "jane@example.com", "456 Oak Ave", "555-0456");
        user2.setId(2L);
        
        List<User> users = Arrays.asList(user1, user2);
        
        when(userService.getAllUsers()).thenReturn(users);
        
        // When & Then
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[1].name").value("Jane Smith"));
    }
    
    @Test
    public void testGetUserById() throws Exception {
        // Given
        User user = new User("John Doe", "john@example.com", "123 Main St", "555-0123");
        user.setId(1L);
        
        when(userService.getUserById(1L)).thenReturn(user);
        
        // When & Then
        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"));
    }
    
    @Test
    public void testCreateUser() throws Exception {
        // Given
        User user = new User("John Doe", "john@example.com", "123 Main St", "555-0123");
        User savedUser = new User("John Doe", "john@example.com", "123 Main St", "555-0123");
        savedUser.setId(1L);
        
        when(userService.createUser(any(User.class))).thenReturn(savedUser);
        
        // When & Then
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"));
    }
    
    @Test
    public void testUpdateUser() throws Exception {
        // Given
        User userToUpdate = new User("John Updated", "john.updated@example.com", "789 New St", "555-0789");
        User updatedUser = new User("John Updated", "john.updated@example.com", "789 New St", "555-0789");
        updatedUser.setId(1L);
        
        when(userService.updateUser(anyLong(), any(User.class))).thenReturn(updatedUser);
        
        // When & Then
        mockMvc.perform(put("/api/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userToUpdate)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("John Updated"))
                .andExpect(jsonPath("$.email").value("john.updated@example.com"));
    }
    
    @Test
    public void testDeleteUser() throws Exception {
        // Given
        doNothing().when(userService).deleteUser(1L);
        
        // When & Then
        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("User deleted successfully"));
    }
}