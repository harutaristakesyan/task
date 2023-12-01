package com.configuration.core.client.notification.service;


import com.configuration.core.client.notification.NotificationClient;

public interface NotificationService {

    void sendMail(NotificationClient.NotificationRequest notificationRequest);

}
