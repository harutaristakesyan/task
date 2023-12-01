package com.web.core.client.notification;

import com.web.core.client.notification.data.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "notification", path = "/api/notification")
public interface NotificationClient {

    @RequestMapping(value = "/mail/send",method = RequestMethod.POST)
    void sendMail(NotificationRequest notificationRequest);
}
