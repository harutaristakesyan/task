package com.notification.notification.service;

import com.notification.mail.model.MailRequest;

public interface NotificationService {
    void sendNotification(MailRequest mailRequest);
}
