package com.gateway.security.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.PathContainer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.web.server.DelegatingServerAuthenticationEntryPoint;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.security.web.server.authentication.HttpStatusServerEntryPoint;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationEntryPoint;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;

import java.util.Set;

@Log4j2
@Configuration
@RequiredArgsConstructor
@ConditionalOnProperty(value = "security.enabled", havingValue = "true")
public class AuthEntryPointConfig {

    private final SecurityProperties securityProperties;

    private final OAuth2ClientProperties clientProperties;

    @Bean
    ServerAuthenticationEntryPoint refAuthenticationEntryPoint() {

        final DelegatingServerAuthenticationEntryPoint entryPoint = new DelegatingServerAuthenticationEntryPoint(
                new DelegatingServerAuthenticationEntryPoint.DelegateEntry(
                        exchange -> {

                            final ServerHttpRequest request = exchange.getRequest();
                            final PathContainer path = request.getPath().pathWithinApplication();

                            if (securityProperties.getApiPrefixes().stream().anyMatch(path.value()::startsWith)) {
                                return ServerWebExchangeMatcher.MatchResult.match();
                            }
                            return ServerWebExchangeMatcher.MatchResult.notMatch();
                        },
                        new HttpStatusServerEntryPoint(HttpStatus.UNAUTHORIZED)
                )
        );

        entryPoint.setDefaultEntryPoint(new RedirectServerAuthenticationEntryPoint(getAuthEntryPointUrl()));

        return entryPoint;
    }

    private String getAuthEntryPointUrl() {
        Set<String> registrations = clientProperties.getRegistration().keySet();
        log.info("stexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        if (registrations.size() == 1) {
            return "/api/oauth2/authorization/" + registrations.stream().findFirst().get();
        } else {
            return "/login";
        }
    }
}
