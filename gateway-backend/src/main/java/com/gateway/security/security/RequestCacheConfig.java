package com.gateway.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.server.savedrequest.CookieServerRequestCache;
import org.springframework.security.web.server.savedrequest.ServerRequestCache;

@Configuration
public class RequestCacheConfig {

    @Bean
    ServerRequestCache requestCache() {
        return new CookieServerRequestCache();
    }
}
