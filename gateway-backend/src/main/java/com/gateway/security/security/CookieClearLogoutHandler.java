package com.gateway.security.security;

import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.logout.ServerLogoutHandler;
import org.springframework.util.Assert;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * logout handler with cookie cleaner
 */
public class CookieClearLogoutHandler implements ServerLogoutHandler {

    private final List<Supplier<ResponseCookie>> cookiesToClear;

    /**
     * List of cookie names to clear when logout
     * @param cookiesToClear
     */
    public CookieClearLogoutHandler(final String... cookiesToClear) {
        Assert.notNull(cookiesToClear, "List of cookies cannot be null");
        final List<Supplier<ResponseCookie>> cookieList = new ArrayList<>();
        for (final String cookieName : cookiesToClear) {
            cookieList.add(() -> ResponseCookie.from(cookieName, "")
                                               .path("/")
                                               .secure(true)
                                               .httpOnly(true)
                                               .maxAge(Duration.ZERO)
                                               .build());
        }
        this.cookiesToClear = cookieList;
    }

    @Override
    public Mono<Void> logout(final WebFilterExchange exchange, final Authentication authentication) {
        final ServerHttpResponse response = exchange.getExchange().getResponse();
        this.cookiesToClear.forEach(cookie -> response.addCookie(cookie.get()));
        return Mono.empty();
    }
}
