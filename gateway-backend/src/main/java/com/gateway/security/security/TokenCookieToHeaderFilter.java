package com.gateway.security.security;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.lang.NonNull;
import org.springframework.security.web.server.util.matcher.OrServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.PathPatternParserServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

import static com.gateway.security.security.WebFluxSecurityConfig.COOKIE_TOKEN;

@Component
@Log4j2
@RequiredArgsConstructor
@ConditionalOnProperty(value = "security.enabled", havingValue = "true")
public class TokenCookieToHeaderFilter implements WebFilter {

    private final SecurityProperties securityProperties;

    private ServerWebExchangeMatcher matcher;

    @PostConstruct
    void init() {

        final List<String> permitAllPaths = securityProperties.getPublicPaths();

        final List<ServerWebExchangeMatcher> matchers = permitAllPaths
                .stream()
                .map(pattern -> new PathPatternParserServerWebExchangeMatcher(pattern, null))
                .collect(Collectors.toList());

        matcher = new OrServerWebExchangeMatcher(matchers);
    }

    @NonNull
    @Override
    public Mono<Void> filter(@NonNull ServerWebExchange exchange, @NonNull WebFilterChain chain) {
        return matcher.matches(exchange)
                .flatMap(matchResult -> {
                    if (matchResult.isMatch()) {
                        return cleanAuthInfoFromRequest(exchange, chain);
                    } else {
                        return replaceTokenCookieToAuthHeader(exchange, chain);
                    }
                });
    }

    private Mono<Void> replaceTokenCookieToAuthHeader(final ServerWebExchange exchange, final WebFilterChain chain) {

        final ServerHttpRequest request = exchange.getRequest();
        final String token = getTokenFromCookie(request);
        if (token != null) {
            log.info("Token found in cookie, replacing it with Authorization header");
            final String cookieHeader = buildCookieHeaderWithoutToken(request);
            final ServerHttpRequest mutated = request
                    .mutate()
                    .header(HttpHeaders.COOKIE, cookieHeader)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                    .build();
            return chain.filter(exchange.mutate().request(mutated).build());

        }
        return chain.filter(exchange);
    }

    /**
     * hack this issue <a href="https://github.com/spring-projects/spring-security/issues/12599">...</a>
     */
    private Mono<Void> cleanAuthInfoFromRequest(final ServerWebExchange exchange, final WebFilterChain chain) {
        final ServerHttpRequest request = exchange.getRequest();
        final String cookieHeader = buildCookieHeaderWithoutToken(request);
        final ServerHttpRequest mutated = request
                .mutate()
                .header(HttpHeaders.COOKIE, cookieHeader)
                .headers(httpHeaders -> httpHeaders.remove(HttpHeaders.AUTHORIZATION))
                .build();
        return chain.filter(exchange.mutate().request(mutated).build());
    }

    private String buildCookieHeaderWithoutToken(final ServerHttpRequest request) {
        return request.getCookies().entrySet().stream()
                .filter(cookie -> !cookie.getKey().equals(COOKIE_TOKEN))
                .flatMap(entry -> entry.getValue().stream())
                .map(HttpCookie::toString)
                .collect(Collectors.joining("; "));
    }

    private String getTokenFromCookie(final ServerHttpRequest request) {
        final HttpCookie cookieToken = request.getCookies().getFirst(COOKIE_TOKEN);
        if (cookieToken != null) {
            return cookieToken.getValue();
        } else {
            return null;
        }
    }
}
