package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.user.AuthEntity;
import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.service.AuthenticationService;
import com.solvd.laba.sinder.service.UserService;
import com.solvd.laba.sinder.web.security.manager.JwtManager;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service//todo
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtManager accessJwtManager;
    private final JwtManager refreshJwtManager;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public void register(AuthEntity authEntity) {
        // todo add user + send email
    }

    @Override
    @Transactional(readOnly = true)
    public AuthEntity login(AuthEntity authEntity) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authEntity.getEmail(),
                        authEntity.getPassword()
                )
        );
        User user = userService.retrieveByEmail(authEntity.getEmail());
        String accessJwt = accessJwtManager.generateToken(user);
        String refreshJwt = refreshJwtManager.generateToken(user);
        return AuthEntity.builder()
                .accessToken(accessJwt)
                .refreshToken(refreshJwt)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public AuthEntity refresh(AuthEntity authEntity) {
        String email = refreshJwtManager.extractClaim(authEntity.getRefreshToken(), Claims::getSubject);
        User user = userService.retrieveByEmail(email);
        String accessJwt = accessJwtManager.generateToken(user);
        String refreshJwt = refreshJwtManager.generateToken(user);
        return AuthEntity.builder()
                .accessToken(accessJwt)
                .refreshToken(refreshJwt)
                .build();
    }

    @Override
    @Transactional
    public AuthEntity enable(AuthEntity authEntity) {
        String email = enableJwtManager.extractClaim(authEntity.getEnableToken(), Claims::getSubject);
        User user = userService.enable(email);
        String accessJwt = accessJwtManager.generateToken(user);
        String refreshJwt = refreshJwtManager.generateToken(user);
        return AuthEntity.builder()
                .accessToken(accessJwt)
                .refreshToken(refreshJwt)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public void requestPasswordRefresh(Long authEntity) {
        // todo send email
    }

    @Override
    @Transactional
    public AuthEntity refreshPassword(AuthEntity authEntity) { //email+newPass
        return null;
    }

    @Override
    @Transactional
    public AuthEntity updatePassword(Long userId, AuthEntity authEntity) { //user+oldPass+newPass

        return null;
    }

}
