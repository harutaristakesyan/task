package com.admin.core.client.notification.service;


import com.admin.core.client.notification.NotificationClient;

public interface NotificationService {

    void sendMail(NotificationClient.NotificationRequest notificationRequest);

}
