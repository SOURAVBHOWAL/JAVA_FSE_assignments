package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void testGetWelcomeMessage() {
        // Mock the dependency
        UserRepository mockRepo = mock(UserRepository.class);

        // Stub the method
        when(mockRepo.findUsernameById(1)).thenReturn("Sourav");

        // Inject the mock
        UserService service = new UserService(mockRepo);

        // Call the method under test
        String message = service.getWelcomeMessage(1);

        // Verify result
        assertEquals("Welcome, Sourav", message);

        // Verify interaction
        verify(mockRepo).findUsernameById(1);
    }
}
