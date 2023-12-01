package com.gateway.security.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;
import org.springframework.security.web.server.savedrequest.ServerRequestCache;

@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
@ConditionalOnProperty(value = "security.enabled", havingValue = "true")
public class WebFluxSecurityConfig {

    public static final String COOKIE_TOKEN = "access-token";

    private final OAuth2LoginSuccessTokenExchanger oAuth2LoginSuccessTokenExchanger;

    private final ServerRequestCache requestCache;

    private final TokenCookieToHeaderFilter tokenFilter;

    private final ServerAuthenticationEntryPoint refAuthenticationEntryPoint;

    private final SecurityProperties securityProperties;

    private final SecurityHeadersSpec securityHeadersSpec;

    private final OAuth2ResourceServerProperties resourceServerProperties;

    /**
     * Webflux security config
     */
    @Bean
    public SecurityWebFilterChain filterChain(final ServerHttpSecurity http) {

        return http
                .formLogin().disable()
                .httpBasic().disable()
                /* replace token from cookie to auth header  */
                .addFilterBefore(tokenFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                /* first do a global login (access.epam.com). config here: spring.security.oauth2.client */
                .oauth2Login()
                /* if global login is successfully get prg-token and exchange it */
                .authenticationSuccessHandler(oAuth2LoginSuccessTokenExchanger)
                .and()
                /* validate ref-token as resource server. config here:  */
                .oauth2ResourceServer().jwt().jwkSetUri(resourceServerProperties.getJwt().getJwkSetUri())
                .and()
                /* auth entry-point. redirect to if auth failed */
                .authenticationEntryPoint(refAuthenticationEntryPoint)
                .and()
                /* Makes the gateway stateless: NoOpServerSecurityContextRepository instead of web session repo */
                .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())
                /* Makes the gateway stateless: CookieServerRequestCache instead of web session cache */
                .requestCache().requestCache(requestCache)
                .and()
                .authorizeExchange()
                /* permit all for health and info endpoints */
                .pathMatchers(securityProperties.getPublicPaths().toArray(new String[0])).permitAll()
                /* any requests must be authenticated */
                .anyExchange().authenticated()
                .and()
                /* stateless csrf token */
                .csrf()
                .csrfTokenRepository(CookieServerCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .headers(securityHeadersSpec.config())
                .logout().logoutHandler(new CookieClearLogoutHandler(COOKIE_TOKEN))
                .and()
                .build();
    }
}
