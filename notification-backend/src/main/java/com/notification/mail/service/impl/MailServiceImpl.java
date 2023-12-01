package com.notification.mail.service.impl;

import com.notification.mail.model.MailRequest;
import com.notification.mail.service.MailService;
import com.notification.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final NotificationService notificationService;

    @Override
    public void sendEmail(final MailRequest mailRequest) {
        //TODO: save mail to database
        notificationService.sendNotification(mailRequest);
    }
}