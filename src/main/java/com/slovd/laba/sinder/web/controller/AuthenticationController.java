package com.slovd.laba.sinder.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {

    @PostMapping("/register")
    public void register(@RequestBody AuthEntityDto authEntityDto) {

    }

    @PostMapping("/login")
    public AuthEntityDto login(@RequestBody AuthEntityDto authEntityDto) {

    }

    @PostMapping("/refresh")
    public AuthEntityDto refresh(@RequestBody AuthEntityDto authEntityDto) {

    }

    @PostMapping("/enable")
    public AuthEntityDto enable() { //request param token

    }

    @PostMapping("/{userId}/password/request")
    public void requestPasswordRefresh() { //ссылка на почту

    }

    @PostMapping("/{userId}/password/refresh")
    public AuthEntityDto refreshPassword(@RequestBody AuthEntityDto authEntityDto) { //set new password

    }

    @PostMapping("/{userId}/password/update")
    public AuthEntityDto updatePassword(@RequestBody AuthEntityDto authEntityDto) {

    }

}
