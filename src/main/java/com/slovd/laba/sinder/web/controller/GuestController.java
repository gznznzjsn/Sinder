package com.slovd.laba.sinder.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{userId}/parties/{partyId}/guests")
public class GuestController {

    @GetMapping()
    public List<UserDto> getAppropriate() {

    }

    @GetMapping("/{guestId}")
    public UserDto getById() {

    }

    @PostMapping("/{guestId}/invite")
    public UserDto invite() {

    }

    @PostMapping("/{guestId}/skip")
    public UserDto skip() {

    }

}
