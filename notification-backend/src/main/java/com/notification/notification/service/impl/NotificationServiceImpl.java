package com.notification.notification.service.impl;

import com.notification.mail.model.MailRequest;
import com.notification.mail.model.properties.TemplateType;
import com.notification.notification.service.NotificationService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGridAPI;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final SendGridAPI sendGridAPI;

    @Override
    @Retryable(retryFor = {IOException.class}, backoff = @Backoff(multiplier = 2))
    public void sendNotification(final MailRequest mailRequest) {
        final var request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(buildMail(mailRequest).build());
            sendGridAPI.api(request);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Mail buildMail(final MailRequest mailRequest) {
        var from = new Email(mailRequest.from(), "MkRezka");
        var mail = new Mail();

        final var templateType = mailRequest.templateType();

        var personalization = buildPersonalization(mailRequest, from, templateType);

        mail.setFrom(from);
        mail.addPersonalization(personalization);
        mail.setTemplateId(templateType.getTemplateId());
        return mail;
    }

    private Personalization buildPersonalization(final MailRequest mailRequest, final Email from, final TemplateType templateType) {
        var personalization = new Personalization();
        personalization.setFrom(from);
        buildTo(mailRequest, personalization);
        buildCC(mailRequest, personalization);

        templateType.buildDynamicTemplateInfo(personalization, mailRequest.body());
        return personalization;
    }

    private void buildTo(final MailRequest mailRequest, final Personalization personalization) {
        if (!mailRequest.to().isEmpty()) {
            mailRequest.to().forEach(to -> personalization.addTo(new Email(to)));
        }

    }

    private void buildCC(final MailRequest mailRequest, final Personalization personalization) {
        if (!mailRequest.cc().isEmpty()) {
            mailRequest.cc().forEach(cc -> personalization.addCc(new Email(cc)));
        }
    }
}
