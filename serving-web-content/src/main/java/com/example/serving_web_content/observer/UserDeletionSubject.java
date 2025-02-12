package com.example.serving_web_content.observer;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDeletionSubject {
    private final List<UserDeletionObserver> observers = new ArrayList<>();

    public void addObserver(UserDeletionObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(Long userId) {
        for (UserDeletionObserver observer : observers) {
            observer.onUserDeleted(userId);
        }
    }
}
