package com.slovd.laba.sinder.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{userId}/parties")
public class PartyController {

    @GetMapping("/{partyId}")
    public PartyDto getById() {

    }

    @PostMapping("/{partyId}")
    public PartyDto publish() {

    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PartyDto create() {

    }

    @DeleteMapping("/{partyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete() {

    }

    @PutMapping("/{partyId}")
    public PartyDto update() {

    }

}
