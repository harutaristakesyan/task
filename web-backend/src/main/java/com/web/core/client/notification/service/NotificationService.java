package com.web.core.client.notification.service;

import com.web.core.client.notification.data.NotificationRequest;

public interface NotificationService {

    void sendMail(NotificationRequest notificationRequest);

}
