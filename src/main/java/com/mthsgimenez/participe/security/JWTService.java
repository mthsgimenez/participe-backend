package com.mthsgimenez.participe.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.mthsgimenez.participe.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Component
public class JWTService {

    @Value("${security.api.token.secret}")
    private String secret;

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(12).toInstant(ZoneOffset.of("-03:00"));
    }

    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(this.secret);

        return JWT.create()
                .withSubject(user.getEmail())
                .withExpiresAt(generateExpirationDate())
                .sign(algorithm);
    }

    private boolean isTokenExpired(String token) {
        return JWT.decode(token).getExpiresAt().before(new Date());
    }

    public String validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(this.secret);

        try {
            if (isTokenExpired(token)) return "";
            return JWT.require(algorithm)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }
}
