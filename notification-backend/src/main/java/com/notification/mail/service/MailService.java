package com.notification.mail.service;

import com.notification.mail.model.MailRequest;

public interface MailService {

    void sendEmail(MailRequest request);
}