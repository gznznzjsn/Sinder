package com.solvd.laba.sinder.web.controller;

import com.solvd.laba.sinder.domain.AuthEntity;
import com.solvd.laba.sinder.service.AuthenticationService;
import com.solvd.laba.sinder.web.dto.AuthEntityDto;
import com.solvd.laba.sinder.web.dto.group.*;
import com.solvd.laba.sinder.web.dto.mapper.AuthEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sinder/v1/authentication")
public class AuthenticationController {

    private final AuthEntityMapper authEntityMapper;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public void register(@Validated(OnRegister.class) @RequestBody AuthEntityDto authEntityDto) {
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        authenticationService.register(authEntity);
    }

    @PostMapping("/login")
    public AuthEntityDto login(@Validated(OnLogin.class) @RequestBody AuthEntityDto authEntityDto) {
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        AuthEntity returnedAuthEntity = authenticationService.login(authEntity);
        return authEntityMapper.toDto(returnedAuthEntity);
    }

    @PostMapping("/refresh")
    public AuthEntityDto refresh(@Validated(OnRefresh.class) @RequestBody AuthEntityDto authEntityDto) {
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        AuthEntity returnedAuthEntity = authenticationService.refresh(authEntity);
        return authEntityMapper.toDto(returnedAuthEntity);
    }

    @GetMapping("/enable")
    public AuthEntityDto enable(@Validated(OnEnable.class) AuthEntityDto authEntityDto) {
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        AuthEntity returnedAuthEntity = authenticationService.enable(authEntity);
        return authEntityMapper.toDto(returnedAuthEntity);
    }

    @PostMapping("/password/request")
    public void requestPasswordRefresh(@Validated(OnRequestPasswordRefresh.class) @RequestBody AuthEntityDto authEntityDto) {
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        authenticationService.requestPasswordRefresh(authEntity);
    }

    @PostMapping("/password/refresh")
    public AuthEntityDto refreshPassword(@Validated(OnPasswordRefresh.class) @RequestBody AuthEntityDto authEntityDto) {
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        AuthEntity returnedAuthEntity = authenticationService.refreshPassword(authEntity);
        return authEntityMapper.toDto(returnedAuthEntity);
    }

    @PreAuthorize("@securityExpressions.isUser(#userId)")
    @PostMapping("/users/{userId}/password/update")
    public AuthEntityDto updatePassword(@Validated(OnUpdatePassword.class) @RequestBody AuthEntityDto authEntityDto,
                                        @PathVariable Long userId) {
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        AuthEntity returnedAuthEntity = authenticationService.updatePassword(userId, authEntity);
        return authEntityMapper.toDto(returnedAuthEntity);
    }

}
