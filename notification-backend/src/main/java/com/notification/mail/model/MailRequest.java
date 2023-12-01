package com.notification.mail.model;

import com.notification.mail.model.properties.TemplateType;

import java.util.Map;
import java.util.Set;

public record MailRequest(String from, Set<String> to, Set<String> cc, TemplateType templateType,
                          Map<String, Object> body) {
}
