package com.configuration.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "external.api")
public class ExternalApiProperties {

    private String fileManagement;
}
