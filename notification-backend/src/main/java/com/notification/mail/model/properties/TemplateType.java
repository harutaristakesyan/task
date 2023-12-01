package com.notification.mail.model.properties;

import com.sendgrid.helpers.mail.objects.Personalization;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public enum TemplateType {

    ORDER() {
        @Override
        public void buildDynamicTemplateInfo(final Personalization personalization, final Map<String, Object> body) {
            personalization.addDynamicTemplateData("name", body.get("name"));
            personalization.addDynamicTemplateData("phone", "tel:" + body.get("phoneNumber"));
            personalization.addDynamicTemplateData("sendTime", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
        }

        @Override
        public String getTemplateId() {
            return ORDER_TEMPLATE_ID;
        }

    };

    public abstract String getTemplateId();

    public abstract void buildDynamicTemplateInfo(final Personalization personalization, final Map<String, Object> body);


    private final static String ORDER_TEMPLATE_ID = "d-4f5efea11a1c4f54a8538ec1202b8542";

}
