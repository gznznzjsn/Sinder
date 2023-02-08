package com.solvd.laba.sinder.web.controller;

import com.solvd.laba.sinder.domain.partymatch.PartyMatch;
import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.service.PartyMatchService;
import com.solvd.laba.sinder.service.UserService;
import com.solvd.laba.sinder.web.dto.PartyMatchDto;
import com.solvd.laba.sinder.web.dto.UserDto;
import com.solvd.laba.sinder.web.dto.mapper.PartyMatchMapper;
import com.solvd.laba.sinder.web.dto.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{userId}/parties/{partyId}/guests")
public class GuestController {

    private final UserService userService;
    private final PartyMatchService partyMatchService;
    private final UserMapper userMapper;
    private final PartyMatchMapper partyMatchMapper;

    @GetMapping()
    public Page<UserDto> getAppropriate(@PathVariable Long userId,
                                        @PathVariable Long partyId,
                                        @PageableDefault(size = 5) Pageable pageable) { //reqParam page! Postman
        Page<User> guests = userService.retrieveGuestsFor(partyId, pageable);
        List<UserDto> guestsDto = userMapper.toDto(guests.getContent());
        return new PageImpl<>(guestsDto);
    }

    @GetMapping("/{guestId}")
    public UserDto getById(@PathVariable Long userId,
                           @PathVariable String partyId,
                           @PathVariable Long guestId) {
        User guest = userService.retrieveById(guestId);
        return userMapper.toDto(guest); //todo another dto
    }

    @PostMapping("/{guestId}/invite")
    public PartyMatchDto invite(@PathVariable Long userId,
                                @PathVariable Long partyId,
                                @PathVariable Long guestId) {
        PartyMatch partyMatch = partyMatchService.inviteGuest(partyId, guestId);
        return partyMatchMapper.toDto(partyMatch);
    }

    @PostMapping("/{guestId}/skip")
    public PartyMatchDto skip(@PathVariable Long userId,
                              @PathVariable Long partyId,
                              @PathVariable Long guestId) {
        PartyMatch partyMatch = partyMatchService.skipGuest(partyId, guestId);
        return partyMatchMapper.toDto(partyMatch);
    }

}
