package com.example.serving_web_content.observer;
import org.springframework.stereotype.Component;

@Component
public class UserDeletionLogger implements UserDeletionObserver {
    @Override
    public void onUserDeleted(Long userId) {
        System.out.println("User with ID: " + userId + " has been deleted!");
    }
}

