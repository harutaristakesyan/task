package com.gateway.security.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@ConditionalOnProperty(value = "security.enabled", havingValue = "false")
public class WebFluxSecurityConfigDisabled {

    @Bean
    public SecurityWebFilterChain filterChain(final ServerHttpSecurity http) {
        return http
                .formLogin().disable()
                .httpBasic().disable()
                .csrf().disable()
                .cors().disable()
                .authorizeExchange()
                .anyExchange()
                .permitAll()
                .and().build();
    }
}
