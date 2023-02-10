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
public class RefreshJwtManager implements JwtManager {

    private static Key refreshKey;

    @Value("${sinder.secrets.refresh-key}")
    public void setRefreshKey(String key) {
        refreshKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return Jwts
                .builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .signWith(refreshKey, SignatureAlgorithm.HS256)
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
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(refreshKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}

