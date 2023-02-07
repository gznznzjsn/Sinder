package com.slovd.laba.sinder.web.controller;

import com.slovd.laba.sinder.domain.AuthEntity;
import com.slovd.laba.sinder.web.dto.AuthEntityDto;
import com.slovd.laba.sinder.web.dto.group.*;
import com.slovd.laba.sinder.web.dto.mapper.AuthEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {

    private final AuthEntityMapper authEntityMapper;

    @PostMapping("/register")
    public void register(@Validated(OnRegister.class) @RequestBody AuthEntityDto authEntityDto) {
        // name, surname, email, password
    }

    @PostMapping("/login")
    public AuthEntityDto login(@Validated(OnLogin.class) @RequestBody AuthEntityDto authEntityDto) {
        // email, password
        AuthEntity authEntity = authEntityMapper.toEntity(authEntityDto);
        return authEntityMapper.toDto(authEntity);
    }

    @PostMapping("/refresh")
    public AuthEntityDto refresh(@Validated(OnRefresh.class) @RequestBody AuthEntityDto authEntityDto) {
        // refreshToken
        return authEntityDto;
    }

    @PostMapping("/enable")
    public AuthEntityDto enable(@Validated(OnEnable.class) AuthEntityDto authEntityDto) {
        return null;
    }

    @PostMapping("/{userId}/password/request")
    public void requestPasswordRefresh(@RequestParam String email) { // OnRequestPasswordRefresh
    }

    @PostMapping("/{userId}/password/refresh")
    public AuthEntityDto refreshPassword(@Validated(OnPasswordRefresh.class) @RequestBody AuthEntityDto authEntityDto) {
        // passwordRefreshToken, password
        return authEntityDto;
    }

    @PostMapping("/{userId}/password/update")
    public AuthEntityDto updatePassword(@Validated(OnUpdatePassword.class) @RequestBody AuthEntityDto authEntityDto) {
        // oldPassword, newPassword
        return authEntityDto;
    }

}
