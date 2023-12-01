package com.gateway.security.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Validated
@ConfigurationProperties("security")
public class SecurityProperties {

    private boolean enabled = true;

    private List<String> apiPrefixes;

    private List<String> publicPaths = new ArrayList<>();

    private Map<String, List<String>> csp = new HashMap<>();
}
