package com.example.demo.runner;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        userRepository.save(new User("Alice"));
        userRepository.save(new User("Bob"));
        userRepository.findAll().forEach(user ->
            System.out.println("Loaded user: " + user.getName())
        );
    }
}
