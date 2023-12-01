package com.admin.core.client.notification.service.impl;

import com.admin.core.client.notification.NotificationClient;
import com.admin.core.client.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class NotificationServiceImpl implements NotificationService {

    private final NotificationClient notificationClient;


    @Async
    @Override
    public void sendMail(final NotificationClient.NotificationRequest notificationRequest) {
        notificationClient.sendMail(notificationRequest);
    }
}
