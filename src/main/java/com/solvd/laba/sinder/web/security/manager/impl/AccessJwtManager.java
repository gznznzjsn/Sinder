package com.solvd.laba.sinder.web.security.manager.impl;

import com.solvd.laba.sinder.web.security.manager.JwtManager;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class AccessJwtManager implements JwtManager {

    private static Key accessKey;

    @Value("${sinder.secrets.access-key}")
    public void setAccessKey(String key) {
        accessKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return Jwts
                .builder()
                .claim("role", userDetails.getAuthorities())
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(accessKey, SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public boolean isValidToken(String token) {
        try {
            return extractClaim(token, Claims::getExpiration).after(new Date(System.currentTimeMillis()));
        } catch (Exception ignored) {
        }
        return false;
    }

    @Override
    public  <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(accessKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
