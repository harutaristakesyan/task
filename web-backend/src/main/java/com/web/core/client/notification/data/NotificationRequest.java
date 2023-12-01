package com.web.core.client.notification.data;

import com.web.core.client.notification.data.properties.TemplateType;

import java.util.Map;
import java.util.Set;

public record NotificationRequest(String from, Set<String> to, Set<String> cc, TemplateType templateType,
                                  Map<String, Object> body) {
}
