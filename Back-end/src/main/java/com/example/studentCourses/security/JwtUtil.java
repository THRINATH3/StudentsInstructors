package com.example.studentCourses.security;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationMs}")
    private long jwtExpirationMs;

    // --------------------- GET SIGNING KEY ---------------------
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    // --------------------- GENERATE TOKEN (UPDATED) ----------------------
    public String generateToken(
            Long id,
            String firstName,
            String lastName,
            String email,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            String bio,     
            String role
    ) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", id);
        claims.put("firstName", firstName);
        claims.put("lastName", lastName);
        claims.put("email", email);
        claims.put("createdAt", createdAt.toString());
        claims.put("updatedAt", updatedAt.toString());
        claims.put("role", role);

        if (bio != null) {
            claims.put("bio", bio);
        }

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    // --------------------- VALIDATE TOKEN ----------------------
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // --------------------- EXTRACT CLAIMS ----------------------
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // --------------------- GETTERS ----------------------

    public String getUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public String getRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    public Long getId(String token) {
        return extractAllClaims(token).get("id", Long.class);
    }

    public String getFirstName(String token) {
        return extractAllClaims(token).get("firstName", String.class);
    }

    public String getLastName(String token) {
        return extractAllClaims(token).get("lastName", String.class);
    }

    public String getEmail(String token) {
        return extractAllClaims(token).get("email", String.class);
    }
}
