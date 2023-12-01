package com.gateway.security.security;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.savedrequest.ServerRequestCache;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static com.gateway.security.security.WebFluxSecurityConfig.COOKIE_TOKEN;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessTokenExchanger extends RedirectServerAuthenticationSuccessHandler {

    private final ReactiveOAuth2AuthorizedClientService clientService;

    private final ServerRequestCache cookieServerRequestCache;

    @PostConstruct
    private void config() {
        super.setRequestCache(cookieServerRequestCache);
    }

    @Override
    public Mono<Void> onAuthenticationSuccess(final WebFilterExchange webFilterExchange, final Authentication authentication) {

        final String registrationId = ((OAuth2AuthenticationToken) authentication).getAuthorizedClientRegistrationId();

        return clientService.loadAuthorizedClient(registrationId, ((DefaultOAuth2User) authentication.getPrincipal()).getName())
                .flatMap(authorizedClient -> {
                    final String token = authorizedClient.getAccessToken().getTokenValue();

                    if (token.length() > 4000) {
                        log.error("The JWT token is too large. Browsers can't store this token in a cookie!");
                    }

                    final ResponseCookie cookieToken = ResponseCookie.fromClientResponse(COOKIE_TOKEN, token)
                            .httpOnly(true)
                            .secure(true)
                            .maxAge(600)
                            .path("/")
                            .build();
                    webFilterExchange.getExchange().getResponse().addCookie(cookieToken);
                    return super.onAuthenticationSuccess(webFilterExchange, authentication);
                });
    }
}
