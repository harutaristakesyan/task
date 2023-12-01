package com.admin.security;

import com.admin.security.model.CustomeUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class JwtConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Autowired
    private JwtDecoder jwtDecoder;

    @Override
    public AbstractAuthenticationToken convert(final Jwt jwt) {
        jwtDecoder.decode(jwt.getTokenValue());
        final CustomeUserDetails user = new CustomeUserDetails();

//        Collection<? extends GrantedAuthority> authorities = Arrays
//                .stream(claims.get(AUTHORITIES_KEY).toString().split(","))
//                .filter(auth -> !auth.trim().isEmpty())
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(user, jwt, Collections.singleton(() -> "CanViewAmenities"));
    }
}