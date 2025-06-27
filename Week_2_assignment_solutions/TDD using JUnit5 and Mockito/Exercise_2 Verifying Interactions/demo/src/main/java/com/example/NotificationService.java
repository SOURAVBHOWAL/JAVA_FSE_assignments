package com.example;

public class NotificationService {
    private Notifier notifier;

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notifyUser(String message) {
        if (message != null && !message.trim().isEmpty()) {
            notifier.send(message);
        }
    }
}
