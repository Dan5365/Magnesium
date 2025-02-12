package com.example.serving_web_content.observer;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class UserDeletionNotifier implements UserDeletionObserver {
    private String lastNotification = "";

    @Override
    public void onUserDeleted(Long userId) {
        lastNotification = " Пользователь с ID " + userId + " успешно удалён!";
    }

    public void clearNotification() {
        lastNotification = "";
    }
}
