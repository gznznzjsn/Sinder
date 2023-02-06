package com.slovd.laba.sinder.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/{userId}/invitations")
public class InvitationController {

    @GetMapping
    public List<PartyDto> getAppropriate() {
    }

    @PostMapping("/{partyId}/request")
    public PartyDto request(){

    }

    @PostMapping("/{partyId}/skip")
    public PartyDto skip(){}


    @GetMapping("/{partyId}")
    public PartyDto getById(){}

}
