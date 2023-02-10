package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.user.AuthEntity;
import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.service.AuthenticationService;
import com.solvd.laba.sinder.service.UserService;
import com.solvd.laba.sinder.web.security.manager.JwtManager;
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
        // todo send email
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
        User user = userService.getByEmail(authEntity.getEmail());
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
        return null;
    }

    @Override
    @Transactional
    public AuthEntity enable(AuthEntity authEntity) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public void requestPasswordRefresh(Long authEntity) {

    }

    @Override
    @Transactional
    public AuthEntity refreshPassword(AuthEntity authEntity) {
        return null;
    }

    @Override
    @Transactional
    public AuthEntity updatePassword(Long userId, AuthEntity authEntity) {
        return null;
    }

}
