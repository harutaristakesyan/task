package com.gateway.security.security;

import org.springframework.cloud.gateway.config.GlobalCorsProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.PathContainer;
import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Mono;

import java.util.List;

@Configuration
public class CorsCsrfConfiguration {

    /**
     * Patched logout cors source
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource(final GlobalCorsProperties globalCorsProperties) {

        final CorsConfiguration logoutCorsConfig = new CorsConfiguration();
        logoutCorsConfig.setAllowedOrigins(List.of(CorsConfiguration.ALL));
        logoutCorsConfig.setAllowedMethods(List.of(HttpMethod.POST.name()));

        final var source = new UrlBasedCorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(final ServerWebExchange exchange) {
                final PathContainer path = exchange.getRequest().getPath().pathWithinApplication();
                if ("/logout".equals(path.value())) {
                    return logoutCorsConfig;
                }
                return super.getCorsConfiguration(exchange);
            }
        };
        globalCorsProperties.getCorsConfigurations().forEach(source::registerCorsConfiguration);
        return source;
    }

    @Bean
    WebFilter addCsrfToken() {
        return (exchange, next) -> {
            final Mono<CsrfToken> csrf = exchange.getAttribute(CsrfToken.class.getName());
            if (csrf != null) {
                return csrf.then(next.filter(exchange));
            } else {
                return next.filter(exchange);
            }
        };
    }

}
