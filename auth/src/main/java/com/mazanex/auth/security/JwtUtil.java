package com.mazanex.auth.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET = "clave_super_larga_para_firmar_tokens_jwt_256bits_minimo_123456";
    private static final long EXPIRATION = 1000L * 60 * 60 * 24; // 24 horas

    // 🔥 Debe ser SecretKey, no Key
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    }

    public String generarToken(Long userId, String email) {
        return Jwts.builder()
                .subject(email)
                .claim("userId", userId)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getSigningKey())  // en 0.12.x ya NO requiere algoritmo
                .compact();
    }

    public Claims validarToken(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())  // 🔥 ahora sí funciona
                .build()
                .parseSignedClaims(token)
                .getPayload();                // antes era getBody()
    }
}
