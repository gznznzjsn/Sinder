package com.slovd.laba.sinder.web.controller;

import com.slovd.laba.sinder.web.dto.PartyDto;
import com.slovd.laba.sinder.web.dto.PartyMatchDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/invitations")
public class InvitationController {

    @GetMapping
    public List<PartyDto> getAppropriate() {
        return null;
    }

    @GetMapping("/{partyId}")
    public PartyDto getById(){
        return null;
    }

    @PostMapping("/{partyId}/request")
    public PartyMatchDto request(){
        // todo maybe void too??
        return null;
    }

    @PostMapping("/{partyId}/skip")
    public PartyMatchDto skip(){
        return null;
    } //todo maybe match dto??

}
