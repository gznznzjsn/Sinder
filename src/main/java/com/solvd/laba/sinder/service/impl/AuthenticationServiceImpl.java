package com.solvd.laba.sinder.service.impl;

import com.solvd.laba.sinder.domain.exception.InvalidPasswordException;
import com.solvd.laba.sinder.domain.AuthEntity;
import com.solvd.laba.sinder.domain.User;
import com.solvd.laba.sinder.service.AuthenticationService;
import com.solvd.laba.sinder.service.MailService;
import com.solvd.laba.sinder.service.UserService;
import com.solvd.laba.sinder.web.security.manager.JwtManager;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final MailService mailService;
    private final PasswordEncoder passwordEncoder;
    private final JwtManager accessJwtManager;
    private final JwtManager refreshJwtManager;
    private final JwtManager enableJwtManager;
    private final JwtManager passwordRefreshJwtManager;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public void register(AuthEntity authEntity) {
        User user = User.builder()
                .name(authEntity.getName())
                .surname(authEntity.getSurname())
                .email(authEntity.getEmail())
                .password(passwordEncoder.encode(authEntity.getPassword()))
                .enabled(false)
                .build();
        user = userService.create(user);
        String enableJwt = enableJwtManager.generateToken(user);
        String subject = "Enable profile";
        String link = "http://localhost:8080/api/v1/authentication/enable?enableToken=" + enableJwt;
        mailService.sendMail(user, "registerUser.ftl", subject, link);
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
    public void requestPasswordRefresh(AuthEntity authEntity) {
        User user = userService.retrieveByEmail(authEntity.getEmail());
        String refreshPasswordJwt = passwordRefreshJwtManager.generateToken(user);
        String subject = "Refresh password";
        String link = "http://localhost:8080/api/v1/authentication/password/request?passwordRefreshToken=" + refreshPasswordJwt;
        mailService.sendMail(user, "refreshPassword.ftl", subject, link);
    }

    @Override
    @Transactional
    public AuthEntity refreshPassword(AuthEntity authEntity) {
        String email = refreshJwtManager.extractClaim(authEntity.getPasswordRefreshToken(), Claims::getSubject);
        User user = userService.retrieveByEmail(email);
        user = userService.updatePassword(user, authEntity.getNewPassword());
        String accessJwt = accessJwtManager.generateToken(user);
        String refreshJwt = refreshJwtManager.generateToken(user);
        return AuthEntity.builder()
                .accessToken(accessJwt)
                .refreshToken(refreshJwt)
                .build();
    }

    @Override
    @Transactional
    public AuthEntity updatePassword(Long userId, AuthEntity authEntity) {
        User user = userService.retrieveById(userId);
        if(!BCrypt.checkpw(authEntity.getPassword(), user.getPassword())){
            throw new InvalidPasswordException("Invalid password!");
        }
        user = userService.updatePassword(user, authEntity.getNewPassword());
        String accessJwt = accessJwtManager.generateToken(user);
        String refreshJwt = refreshJwtManager.generateToken(user);
        return AuthEntity.builder()
                .accessToken(accessJwt)
                .refreshToken(refreshJwt)
                .build();
    }

}
