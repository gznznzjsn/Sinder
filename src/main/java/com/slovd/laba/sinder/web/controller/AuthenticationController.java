package com.slovd.laba.sinder.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AuthenticationController {

    @PostMapping("/login")
    public UserDto register(@RequestBody UserDto userDto) {

    }

    @PostMapping("/login")
    public JwtResponseDto login(@RequestBody JwtRequestDto jwtRequestDto) {

    }

    @PostMapping("/refresh")
    public JwtResponseDto refresh(@RequestBody JwtRefreshRequestDto jwtRefreshRequestDto) {

    }

}
