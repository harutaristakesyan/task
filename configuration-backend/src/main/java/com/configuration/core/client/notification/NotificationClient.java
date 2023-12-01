package com.configuration.core.client.notification;

import com.configuration.core.client.notification.properties.TemplateType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.Set;

@FeignClient(value = "notification", path = "/api/notification")
public interface NotificationClient {

    @RequestMapping(value = "/mail/send", method = RequestMethod.POST)
    void sendMail(NotificationRequest notificationRequest);


    record NotificationRequest(String from, Set<String> to, Set<String> cc, TemplateType templateType,
                               Map<String, Object> body) {
    }
}
