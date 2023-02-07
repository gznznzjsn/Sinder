package com.solvd.laba.sinder.web.controller;

import com.solvd.laba.sinder.web.dto.PartyMatchDto;
import com.solvd.laba.sinder.web.dto.UserDto;
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
    public PartyMatchDto invite() {
        return null;
    }

    @PostMapping("/{guestId}/skip")
    public PartyMatchDto skip() {
        return null;
    }

}
