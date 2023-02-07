package com.slovd.laba.sinder.web.controller;

import com.slovd.laba.sinder.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{userId}/parties/{partyId}/guests")
public class GuestController {

    @GetMapping()
    public List<UserDto> getAppropriate() {
        return null;
    }

    @GetMapping("/{guestId}")
    public UserDto getById() {
        return null;
    }

    @PostMapping("/{guestId}/invite")
    public UserDto invite() {
        return null;
    }

    @PostMapping("/{guestId}/skip")
    public UserDto skip() { // todo maybe match dto??
        return null;
    }

}
