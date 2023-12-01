package com.web.core.client.notification.service.impl;

import com.web.core.client.notification.NotificationClient;
import com.web.core.client.notification.data.NotificationRequest;
import com.web.core.client.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class NotificationServiceImpl implements NotificationService {

    private final NotificationClient notificationClient;


    @Async
    @Override
    public void sendMail(final NotificationRequest notificationRequest) {
        notificationClient.sendMail(notificationRequest);
    }
}
