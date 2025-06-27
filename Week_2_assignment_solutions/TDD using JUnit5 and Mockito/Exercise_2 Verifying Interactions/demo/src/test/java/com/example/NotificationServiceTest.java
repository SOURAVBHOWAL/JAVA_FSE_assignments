package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class NotificationServiceTest {

    @Test
    void testNotifierCalledWithValidMessage() {
        Notifier mockNotifier = mock(Notifier.class);
        NotificationService service = new NotificationService(mockNotifier);

        service.notifyUser("Hello, user!");

        // ✅ Verify send() was called once with the expected message
        verify(mockNotifier).send("Hello, user!");
    }

    @Test
    void testNotifierNotCalledWithEmptyMessage() {
        Notifier mockNotifier = mock(Notifier.class);
        NotificationService service = new NotificationService(mockNotifier);

        service.notifyUser("  "); // blank message

        // ✅ Verify send() was never called
        verify(mockNotifier, never()).send(anyString());
    }

    @Test
    void testNotifierCalledMultipleTimes() {
        Notifier mockNotifier = mock(Notifier.class);
        NotificationService service = new NotificationService(mockNotifier);

        service.notifyUser("One");
        service.notifyUser("Two");

        // ✅ Verify send() called exactly twice
        verify(mockNotifier, times(2)).send(anyString());
    }
}
