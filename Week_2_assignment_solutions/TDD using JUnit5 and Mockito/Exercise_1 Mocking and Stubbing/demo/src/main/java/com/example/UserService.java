package com.example;

public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String getWelcomeMessage(int userId) {
        String username = repository.findUsernameById(userId);
        return "Welcome, " + username;
    }
}
