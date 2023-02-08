package com.solvd.laba.sinder.web.controller;

import com.solvd.laba.sinder.domain.user.AuthEntity;
import com.solvd.laba.sinder.service.AuthenticationService;
import com.solvd.laba.sinder.web.dto.AuthEntityDto;
import com.solvd.laba.sinder.web.dto.group.*;
import com.solvd.laba.sinder.web.dto.mapper.AuthEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {

    private final AuthEntityMapper authEntityMapper;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public void register(@Validated(OnRegister.class) @RequestBody AuthEntityDto authEntityDto) {
        // name, surname, email, password
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        authenticationService.register(authEntity);
    }

    @PostMapping("/login")
    public AuthEntityDto login(@Validated(OnLogin.class) @RequestBody AuthEntityDto authEntityDto) {
        // email, password
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        AuthEntity returnedAuthEntity = authenticationService.login(authEntity);
        return authEntityMapper.toDto(returnedAuthEntity);
    }

    @PostMapping("/refresh")
    public AuthEntityDto refresh(@Validated(OnRefresh.class) @RequestBody AuthEntityDto authEntityDto) {
        // refreshToken
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        AuthEntity returnedAuthEntity = authenticationService.refresh(authEntity);
        return authEntityMapper.toDto(returnedAuthEntity);
    }

    @PostMapping("/enable")
    public AuthEntityDto enable(@Validated(OnEnable.class) AuthEntityDto authEntityDto) {
        // enableToken
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        AuthEntity returnedAuthEntity = authenticationService.enable(authEntity);
        return authEntityMapper.toDto(returnedAuthEntity);
    }

    @PostMapping("/{userId}/password/request")
    public void requestPasswordRefresh(@PathVariable Long userId) {
        authenticationService.requestPasswordRefresh(userId);
    }

    @PostMapping("/{userId}/password/refresh")
    public AuthEntityDto refreshPassword(@Validated(OnPasswordRefresh.class) @RequestBody AuthEntityDto authEntityDto, @PathVariable String userId) {
        // passwordRefreshToken, password
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        AuthEntity returnedAuthEntity = authenticationService.refreshPassword(authEntity);
        return authEntityMapper.toDto(returnedAuthEntity);
    }

    @PostMapping("/{userId}/password/update")
    public AuthEntityDto updatePassword(@Validated(OnUpdatePassword.class) @RequestBody AuthEntityDto authEntityDto, @PathVariable Long userId) {
        // oldPassword, newPassword
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        AuthEntity returnedAuthEntity = authenticationService.updatePassword(userId, authEntity);
        return authEntityMapper.toDto(returnedAuthEntity);
    }

}
