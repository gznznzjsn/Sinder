package com.slovd.laba.sinder.web.controller;

import com.slovd.laba.sinder.web.dto.AuthEntityDto;
import com.slovd.laba.sinder.web.dto.group.*;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {

    @PostMapping("/register")
    public void register(@Validated(OnRegister.class) @RequestBody AuthEntityDto authEntityDto) { //ссылка на почту
        // name, surname, email, password
    }

    @PostMapping("/login")
    public AuthEntityDto login(@Validated(OnLogin.class) @RequestBody AuthEntityDto authEntityDto) {
        // email, password
        return authEntityDto;
    }

    @PostMapping("/refresh")
    public AuthEntityDto refresh(@Validated(OnRefresh.class) @RequestBody AuthEntityDto authEntityDto) {
        // refreshToken
        return authEntityDto;
    }

    @PostMapping("/enable")
    public AuthEntityDto enable(@RequestParam String enableToken) {
        return null;
    }

    @PostMapping("/{userId}/password/request")
    public void requestPasswordRefresh(@RequestParam String email) {
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
