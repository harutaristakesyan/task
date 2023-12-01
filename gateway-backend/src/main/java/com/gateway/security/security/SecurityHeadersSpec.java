package com.gateway.security.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.header.ReferrerPolicyServerHttpHeadersWriter;
import org.springframework.security.web.server.header.XFrameOptionsServerHttpHeadersWriter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.cloud.gateway.filter.factory.SecureHeadersProperties.CONTENT_SECURITY_POLICY_HEADER_DEFAULT;

@Component
@RequiredArgsConstructor
public class SecurityHeadersSpec {

    private final SecurityProperties securityProperties;

    Customizer<ServerHttpSecurity.HeaderSpec> config() {
        return headerSpec -> headerSpec
            .hsts().includeSubdomains(true).preload(true).and()
            .frameOptions().mode(XFrameOptionsServerHttpHeadersWriter.Mode.SAMEORIGIN)
            .referrerPolicy().policy(ReferrerPolicyServerHttpHeadersWriter.ReferrerPolicy.STRICT_ORIGIN_WHEN_CROSS_ORIGIN).and()
            .contentSecurityPolicy(cspDirectivesBuilder());
    }

    private String cspDirectivesBuilder() {
        final String policy = securityProperties.getCsp().entrySet().stream()
                                                .flatMap(entry -> Stream.of(entry.getKey(), " ", String.join(" ", entry.getValue()), "; "))
                                                .collect(Collectors.joining());

        return StringUtils.hasLength(policy) ? policy : CONTENT_SECURITY_POLICY_HEADER_DEFAULT;
    }
}